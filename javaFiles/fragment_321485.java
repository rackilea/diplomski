import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;

public class MyApp {

    public static void main(String[] args) throws Exception {

        InputStream is = new ByteArrayInputStream("hi I am test".getBytes(Charset.forName("UTF-8")));

        DataInputStream dataIn = new DataInputStream(is);
        while (dataIn.available() > 0) {
            String k = dataIn.readLine();
            System.out.print(k + " ");
        }
    }

}