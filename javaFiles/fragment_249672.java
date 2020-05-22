import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.Files;

/** 
 * compile using jdk1.7
 *
 */
public class ReadFileLastAccess {

    /**
     * @param args
     */
    public static void main(String[] args) throws Exception
    {
        Path file_dir = Paths.get("/home/user/");
        Path file = file_dir.resolve("testfile.txt");
        BasicFileAttributes attrs = Files.readAttributes(file, BasicFileAttributes.class);       
        System.out.println("Last accessed at:" + attrs.lastAccessTime());

    }

}