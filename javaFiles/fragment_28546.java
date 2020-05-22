import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItem;


public class TestFile {

    public static void main(String args[]) throws IOException {
        // This is a sample inputStream, use your own.
        InputStream inputStream = new FileInputStream("c:\\Kit\\Apache\\geronimo-tomcat6-javaee5-2.1.6\\README.txt");

        int availableBytes = inputStream.available();

        // Write the inputStream to a FileItem
        File outFile = new File("c:\\tmp\\newfile.xml"); // This is your tmp file, the code stores the file here in order to avoid storing it in memory
        FileItem fileItem = new DiskFileItem("fileUpload", "plain/text", false, "sometext.txt", availableBytes, outFile); // You link FileItem to the tmp outFile 
        OutputStream outputStream = fileItem.getOutputStream(); // Last step is to get FileItem's output stream, and write your inputStream in it. This is the way to write to your FileItem. 

        int read = 0;
        byte[] bytes = new byte[1024];
        while ((read = inputStream.read(bytes)) != -1) {
            outputStream.write(bytes, 0, read);
        }

        // Don't forget to release all the resources when you're done with them, or you may encounter memory/resource leaks.
        inputStream.close();
        outputStream.flush(); // This actually causes the bytes to be written.
        outputStream.close();

        // NOTE: You may also want to delete your outFile if you are done with it and dont want to take space on disk.
    }
}