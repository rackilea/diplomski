import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

    final ByteArrayOutputStream baos = new ByteArrayOutputStream();
    final String utf8 = StandardCharsets.UTF_8.name();
    try (PrintStream ps = new PrintStream(baos, true, utf8)) {
        yourFunction(object, ps);
    }
    String data = baos.toString(utf8);