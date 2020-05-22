import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class InternetReader {

    private static void copyInputStreamToOutputstream(InputStream in, OutputStream out) throws IOException {
        byte[] buf = new byte[1024];
        int len;
        while ((len = in.read(buf)) > 0) {
            out.write(buf, 0, len);
        }
    }

    public static void main(String[] args) throws IOException {
        File f = new File("http://google.be/test.jpg");
        System.out.println(f.getName());
        File localPath = new File("/cdn/opt");
        File localDestination = new File(localPath, f.getName());
        URL remoteURL = new URL("http://google.be/test.jpg");
        try (InputStream is = remoteURL.openStream(); OutputStream os = new FileOutputStream(localDestination)) {
            copyInputStreamToOutputstream(is, os);
        }
    }

}