import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;

Path libraryFile = Paths.get("path/to/Library.txt");
byte[] data = Files.readAllBytes(libraryFile);