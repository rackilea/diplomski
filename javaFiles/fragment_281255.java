import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.jar.Attributes;
import java.util.jar.Manifest;

import static java.nio.charset.StandardCharsets.UTF_8;
import static java.util.jar.Attributes.Name.MANIFEST_VERSION;

public class ManifestTest {
  public static void main(String[] args) throws IOException {
    Manifest m = new Manifest();
    Attributes a = m.getMainAttributes();
    a.put(MANIFEST_VERSION, "1.0"); // required or the file doesn't get written

    // Long-Property: This line has 72 characters without eol, it's hard to get
    a.putValue("Line-Property", "This line has 72 characters without eol, it's hard to get");
    // Long-Property: This line has 72 characters with eol, it is hard to get
    a.putValue("Long-Property", "This line has 72 characters with eol, it is hard to get");
    a.putValue("Massive-Property", "This line wraps around always as it has a lot of characters in it");

    ByteArrayOutputStream out = new ByteArrayOutputStream();
    m.write(out);
    System.out.println(new String(out.toByteArray(), UTF_8));
  }
}