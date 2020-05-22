import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import static java.nio.charset.StandardCharsets.UTF_8;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.DELETE_ON_CLOSE;
import static java.nio.file.StandardOpenOption.READ;

public class DeleteOnClose {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("/tmp/test");
        System.out.println("before create: " + Files.exists(path));
        Files.createFile(path);
        System.out.println("after create: " + Files.exists(path));
        try (InputStream in = Files.newInputStream(path, READ);
                OutputStream out = Files.newOutputStream(path, APPEND, 
                        DELETE_ON_CLOSE)) {
            out.write("Hello file!".getBytes(UTF_8));
            out.flush();

            for (int c = in.read(); c >= 0; c = in.read()) {
                System.out.print((char) c);
            }
            System.out.println();
        }
        System.out.println("after close: " + Files.exists(path));
    }
}