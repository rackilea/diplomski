import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Detect {

    /**
     * Resolves the MediaType using Tika and prints it to the standard output.
     * @param file the path of the file to probe.
     * @throws IOException whenever an I/O exception occurs.
     */
    private void detect(Path file) throws IOException {
        Tika tika = new Tika();
        try(InputStream is = Files.newInputStream(file)){
            MediaType mediaType = MediaType.parse(tika.detect(is));
            System.out.println(mediaType);
        }
    }

    public static void main(String[] args) throws IOException {
        Detect d = new Detect();
        d.detect(Paths.get("zip_file"));
        d.detect(Paths.get("csv_file"));
    }
}