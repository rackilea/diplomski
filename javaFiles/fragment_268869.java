import com.microsoft.azure.storage.CloudStorageAccount;
import com.microsoft.azure.storage.StorageException;
import com.microsoft.azure.storage.blob.CloudBlobClient;
import com.microsoft.azure.storage.blob.CloudBlobContainer;
import com.microsoft.azure.storage.blob.CloudBlockBlob;
import com.vaadin.ui.Upload;
import org.springframework.stereotype.Component;

import java.io.OutputStream;
import java.net.URISyntaxException;
import java.security.InvalidKeyException;

@Component
public class UploadReceiver implements Upload.Receiver, Upload.StartedListener, Upload.SucceededListener, Upload.ProgressListener {
    // Storage account connection string.
    public static String conn = "DefaultEndpointsProtocol=https;AccountName=stora***789;AccountKey=G3***w==;EndpointSuffix=core.windows.net";

    @Override
    public OutputStream receiveUpload(String filename, String mimeType) {
        System.out.println("Uploading -> " + mimeType + " ; File name -> " + filename);
        return GetOutputStream("vaadin",filename);
    }

    @Override
    public void uploadStarted(Upload.StartedEvent startedEvent) {
        System.out.println("Upload started!");
    }

    @Override
    public void uploadSucceeded(Upload.SucceededEvent succeededEvent) {
        System.out.println("Upload succeeded!");
    }


    public OutputStream GetOutputStream(String container, String blob){
        OutputStream outputStream = null;
        try{
            CloudStorageAccount storageAccount = CloudStorageAccount.parse(conn);
            CloudBlobClient blobClient = storageAccount.createCloudBlobClient();
            CloudBlobContainer blobContainer = blobClient.getContainerReference(container);
            CloudBlockBlob cloudBlockBlob = blobContainer.getBlockBlobReference(blob);
            outputStream = cloudBlockBlob.openOutputStream();
        } catch (StorageException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return outputStream;
    }

    @Override
    public void updateProgress(long readBytes, long contentLength) {
        System.out.println("Progress: readBytes -> " + readBytes + " ; contentLength -> " + contentLength);
    }
}