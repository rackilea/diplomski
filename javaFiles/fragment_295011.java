import java.io.*;
import java.net.*;

public class ReadBytes {
    public static void main( String [] args ) throws IOException {

        URL url = new URL("http://your image url");

            // Read the image ...
        InputStream inputStream      = url.openStream();
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        byte [] buffer               = new byte[ 1024 ];

        int n = 0;
        while (-1 != (n = inputStream.read(buffer))) {
           output.write(buffer, 0, n);
        }
        inputStream.close();

        // Here's the content of the image...
        byte [] data = output.toByteArray();

    // Write it to a file just to compare...
    OutputStream out = new FileOutputStream("data.png");
    out.write( data );
    out.close();

    // Print it to stdout 
        for( byte b : data ) {
            System.out.printf("0x%x ", b);
        }
    }
}