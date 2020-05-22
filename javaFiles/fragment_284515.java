import java.nio.file.Path;

public interface Factory {
    Data create();
    Data load(Path path);
}