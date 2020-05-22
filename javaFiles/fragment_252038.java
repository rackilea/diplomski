import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.CompleteMultipartUploadRequest;
import com.amazonaws.services.s3.model.InitiateMultipartUploadRequest;
import com.amazonaws.services.s3.model.InitiateMultipartUploadResult;
import com.amazonaws.services.s3.model.PartETag;
import com.amazonaws.services.s3.model.UploadPartRequest;
import com.amazonaws.services.s3.model.UploadPartResult;
import com.box.sdk.BoxAPIConnection;
import com.box.sdk.BoxFile;
import com.box.sdk.BoxFolder;
import com.box.sdk.BoxItem;
import com.box.sdk.Metadata;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.io.FileUtils;

public static String fileObjKeyName = "";
public static String bucketName = "s3Bucket";
// store credentials in your local machine in aws config / credentials file.
public static ProfileCredentialsProvider credentialsProvider = new ProfileCredentialsProvider();
public static AmazonS3 s3Client = AmazonS3ClientBuilder
            .standard()
            .withCredentials(credentialsProvider)
            .withRegion(regionfOfS3Bucket)
            .build();
String access_token = "some_access_token";
String refresh_token = "some_refresh_token";
BoxAPIConnection api = new BoxAPIConnection(client_id,
                client_secret,
                access_token,
                refresh_token);
BoxFolder folder = new BoxFolder(api,folderId);

for (BoxItem.Info itemInfo : folder) {
    if (itemInfo instanceof BoxFile.Info) {
        // getting file info, metadata
        // have to upload the file content here to S3 bucket
        BoxFile file = new BoxFile(api, itemInfo.getID());
                BoxFile.Info info = file.getInfo();
                System.out.println(info.getName());
                FileOutputStream stream;
                try {
                    stream = new FileOutputStream(info.getName());
                    file.download(stream);
                    stream.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

                File file_new = FileUtils.getFile(info.getName());
                fileObjKeyName =  itemInfo.getID() + "_" + info.getName();
                long contentLength = file_new.length();
                System.out.println(contentLength);
                long partSize = 5 * 1024 * 1024;
                List<PartETag> partETags = new ArrayList<PartETag>();
                InitiateMultipartUploadRequest initRequest = new InitiateMultipartUploadRequest(bucketName, fileObjKeyName);
                InitiateMultipartUploadResult initResponse = s3Client.initiateMultipartUpload(initRequest);
                long filePosition = 0;
                for (int i = 1; filePosition < contentLength; i++) {
                    // Because the last part could be less than 5 MB, adjust the
                    // part size as needed.
                    partSize = Math.min(partSize, (contentLength - filePosition));
                    // Create the request to upload a part.
                    UploadPartRequest uploadRequest = new UploadPartRequest().withBucketName(bucketName).withKey(fileObjKeyName)
                            .withUploadId(initResponse.getUploadId()).withPartNumber(i).withFileOffset(filePosition).withFile(file_new).withPartSize(partSize);

                    // Upload the part and add the response's ETag to our list.
                    UploadPartResult uploadResult = s3Client.uploadPart(uploadRequest);
                    partETags.add(uploadResult.getPartETag());

                    filePosition += partSize;
                }
                CompleteMultipartUploadRequest compRequest = new CompleteMultipartUploadRequest(bucketName, fileObjKeyName, initResponse.getUploadId(), partETags);
                s3Client.completeMultipartUpload(compRequest);
                file_new.delete();
    } else if (itemInfo instanceof BoxFolder.Info)
    {
        BoxFolder.Info folderInfo = (BoxFolder.Info) itemInfo;
       // Do something with the folder.


     }
        }