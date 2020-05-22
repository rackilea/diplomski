import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;

Path fp = Paths.get("file_path");
byte[] data = Files.readAllBytes(fp);