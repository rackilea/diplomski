import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Lab1 {

    public static void main(String[] args)  {
            String chromVersion = "myChromeVersion";
        try {
            Path path = Paths.get("C:\\whatever\\path\\toYourFile.txt");
            List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
            int lineToModify = 31;
            lines.set(lineToModify, lines.get(lineToModify)+ chromVersion);
            Files.write(path, lines, StandardCharsets.UTF_8);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}