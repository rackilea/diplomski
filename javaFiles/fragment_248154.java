import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.List;

public class FileDataService {

    public static void main(String...args) {
        new FileDataService().loadData();
    }

    public void loadData() {

        try {

            File file = new File("C:/Java/test.txt");
            List<String> anyLines = Files.readAllLines(file.toPath(), Charset.defaultCharset());

            for (String line : anyLines) {
                System.out.println(line);

            }

        } catch (IOException e) {
            System.out.println(e.getMessage());

        }

    }
}