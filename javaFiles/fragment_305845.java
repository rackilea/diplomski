fge@alustriel:~/tmp/filenameenc$ echo $LC_ALL
en_US.UTF-8
fge@alustriel:~/tmp/filenameenc$ cat Test.java
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Test
{

    public static void main(String[] args)
    {
        final String testString = "a/üöä";
        final Path path = Paths.get(testString);
        final File file = new File(testString);
        System.out.println("Files.exists(): " + Files.exists(path));
        System.out.println("File exists: " + file.exists());
    }
}
fge@alustriel:~/tmp/filenameenc$ install -D /dev/null a/üöä 
fge@alustriel:~/tmp/filenameenc$ java Test
Files.exists(): true
File exists: true
fge@alustriel:~/tmp/filenameenc$ java -Dfile.encoding=iso-8859-1 Test
Files.exists(): false
File exists: true
fge@alustriel:~/tmp/filenameenc$