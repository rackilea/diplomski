import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;

public class FileReader {
    public List<String> read(String fileName) throws IOException{
        return Files.lines(new File(fileName).toPath()).collect(Collectors.toList());       
    }
}