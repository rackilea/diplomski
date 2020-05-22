import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

try {
    final Path path = Paths.get(basePath + "/" + fileName);
    return Files.probeContentType(path);
} catch (final Exception exception) {
    return "<EXCEPTION: " + exception.getMessage() + ">";
}