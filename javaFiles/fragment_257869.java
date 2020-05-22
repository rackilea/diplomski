import java.io.File;
import java.io.OutputStream;
import java.nio.file.Files;
import static java.nio.file.StandardOpenOption.CREATE_NEW;
public class Main {
    public static void main(String[] args) throws Exception {
        File file = new File("/tmp/test");
        file.deleteOnExit();
        System.out.println("tempFile = " + tempFile);
        try (OutputStream outputStream = Files.newOutputStream(file.toPath(),
                CREATE_NEW)) {
            outputStream.write(123);
            outputStream.flush();
            System.out.println("done");
        }
        System.out.printf("%s exists: %s%n", file, file.exists());
    }
}