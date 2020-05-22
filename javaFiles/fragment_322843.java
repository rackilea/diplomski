import java.nio.file.*;

public class JavaIO {
    public static void main(String[] args) throws java.io.IOException {

        String dirString = "C:/Users/USER/Desktop/Test/Files";
        Path dirPath = Paths.get(dirString);
        if(Files.notExists(dirPath)){
            Files.createDirectory(dirPath);
        }
        System.out.println("Err");
        System.exit(1);
    }
}