import java.net.URL;
import java.io.InputStream;

public class Fetch {
    public static void main(final String[] args) throws Exception {
        final URL targetURL = new URL("https://repository.jboss.org/nexus/content/groups/public/javax/media/jai-core/1.1.3/jai-core-1.1.3.pom");
        try (final InputStream is = targetURL.openConnection().getInputStream()) {
            is.read();
        }
        System.out.println("Done");
    }
}