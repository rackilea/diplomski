import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class Test {
    public static void main(String[] args) throws MalformedURLException {
        URL.setURLStreamHandlerFactory(protocol -> {
            throw new UnsupportedOperationException();
        });

        System.out.println(new File("/etc/passwd").toURI().toURL());
    }
}