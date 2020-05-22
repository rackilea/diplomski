import java.io.*;
import java.nio.charset.*;
import org.apache.commons.io.*;

public String readFile(String fileName) throws IOException {
    File file = new File(fileName);
    return FileUtils.readFileToString(file, StandardCharsets.UTF_8);
}