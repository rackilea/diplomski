import java.io.BufferedInputStream;
    import java.io.ByteArrayOutputStream;
    import java.io.FileOutputStream;
    import java.io.IOException;
    import java.io.InputStream;
    import java.net.URL;


    public class DownloadFile {

      public static void main(String[] args) throws IOException {

             String fileName = "fileName.txt"; 
             URL link = new URL("http://websiteToDownloadFrom.com");

             InputStream in = new BufferedInputStream(link.openStream());
             ByteArrayOutputStream out = new ByteArrayOutputStream();
             byte[] buf = new byte[1024];
             int n = 0;
             while (-1!=(n=in.read(buf)))
             {
                out.write(buf, 0, n);
             }
             out.close();
             in.close();
             byte[] response = out.toByteArray();

             FileOutputStream fos = new FileOutputStream(fileName);
             fos.write(response);
             fos.close();

    }
}