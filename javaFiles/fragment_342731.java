import java.net.URI;
import java.net.URISyntaxException;

public class URITest {

    public static void main(String[] args) throws URISyntaxException {
        URI uri = new URI("http", "user:p@ss", "example.com", -1,
                null, null, null);
        System.out.println(uri.toString());

        URI uri2 = new URI(uri.toString());
        System.out.println(uri2.getUserInfo());
    }
}