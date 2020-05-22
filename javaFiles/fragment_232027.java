import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.junit.BeforeClass;
import org.junit.Test;


public class DeleteDirectoryTest {
    private static final String DIRECTORY_PATH = "C:/TEMP";

    @BeforeClass
    public static void cleanUp() throws IOException {
        FileUtils.deleteDirectory(new File(DIRECTORY_PATH));
    }

    @Test
    public void doSomeTest() {
        // Test code goes here
   }
}