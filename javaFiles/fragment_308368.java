import java.io.File;
import java.io.IOException;

public class TempFolder {
    public static void main(String[] args) throws IOException {
        File file = File.createTempFile("my_prefix", "");
        System.out.println(file.getAbsolutePath() + " isFile: " + file.isFile() + " isDir:" + file.isDirectory());
        file.delete();
        file.mkdir();
        System.out.println(file.getAbsolutePath() + " isFile: " + file.isFile() + " isDir:" + file.isDirectory());
    }
}