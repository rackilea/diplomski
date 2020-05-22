package roee.gavriel;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CompleteMultipartUploadRequest;
import com.amazonaws.services.s3.model.InitiateMultipartUploadRequest;
import com.amazonaws.services.s3.model.InitiateMultipartUploadResult;
import com.amazonaws.services.s3.model.PartETag;
import com.amazonaws.services.s3.model.UploadPartRequest;

public class S3UploadStream extends OutputStream {

    private final static Integer PART_SIZE = 5 * 1024 * 1024;

    private final AmazonS3 s3client;
    private final String bucket;
    private final String key;

    // The upload id given to the multiple parts upload by AWS.
    private final String uploadId;
    // A tag list. AWS give one for each part and expect then when the upload is finish.
    private final List<PartETag> partETags = new LinkedList<>();
    // A buffer to collect the data before sending it to AWS.
    private byte[] partData = new byte[PART_SIZE];
    // The index of the next free byte on the buffer.
    private int partDataIndex = 0;
    // Total number of parts that where uploaded.
    private int totalPartCountIndex = 0;
    private volatile Boolean closed = false;
    // Internal thread pool which will handle the actual part uploading.
    private final ThreadPoolExecutor executor;

    public S3UploadStream(AmazonS3 s3client, String bucket, String key, int uploadThreadsCount) {
        this.s3client = s3client;
        this.bucket = bucket;
        this.key = key;
        InitiateMultipartUploadRequest initRequest = new InitiateMultipartUploadRequest(bucket, key);
        InitiateMultipartUploadResult initResponse = s3client.initiateMultipartUpload(initRequest);
        this.uploadId = initResponse.getUploadId();
        this.executor = new ThreadPoolExecutor(uploadThreadsCount, uploadThreadsCount, 60, TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>(100));
    }


    @Override
    public synchronized void write(int b) throws IOException {
        if (closed) {
            throw new IOException("Trying to write to a closed S3UploadStream");
        }
        partData[partDataIndex++] = (byte)b;
        uploadPart(false);
    }

    @Override
    public synchronized void close() {
        if (closed) {
            return;
        }
        closed = true;

        // Flush the current data in the buffer
        uploadPart(true);

        executor.shutdown();
        try {
            executor.awaitTermination(2, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            //Nothing to do here...
        }

        // Close the multiple part upload
        CompleteMultipartUploadRequest compRequest = 
                new CompleteMultipartUploadRequest(bucket, key, uploadId, partETags);

        s3client.completeMultipartUpload(compRequest);

    }

    private synchronized void uploadPart(Boolean force) {

        if (!force && partDataIndex < PART_SIZE) {
            // the API requires that only the last part can be smaller than 5Mb
            return;
        }

        // Actually start the upload
        createUploadPartTask(partData, partDataIndex);

        // We are going to upload the current part, so start buffering data to new part
        partData = new byte[PART_SIZE];
        partDataIndex = 0;          
    }

    private synchronized void createUploadPartTask(byte[] partData, int partDataIndex) {
        // Create an Input stream of the data
        InputStream stream = new ByteArrayInputStream(partData, 0, partDataIndex);

        // Build the upload request
        UploadPartRequest uploadRequest = new UploadPartRequest()
                .withBucketName(bucket)
                .withKey(key)
                .withUploadId(uploadId)
                .withPartNumber(++totalPartCountIndex)
                .withInputStream(stream)
                .withPartSize(partDataIndex);

        // Upload part and add response to our tag list.
        // Make the actual upload in a different thread
        executor.execute(() -> {
            PartETag partETag = s3client.uploadPart(uploadRequest).getPartETag();
            synchronized (partETags) {
                partETags.add(partETag);
            }
        });
    }   
}