import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;

Path path = Paths.get("path/to/my/file");
byte[] data = Files.readAllBytes(path);