import static org.junit.Assert.*;
import java.io.*;
import org.apache.commons.io.FileUtils;
import org.junit.*;
import org.tmatesoft.svn.core.*;

public class SVNTest {

    private static final String path = "/tmp/testrepo";
    SVNURL tgtURL;

    @Before
    public void setUp() throws Exception {
        SVNRepositoryFactoryImpl.setup();
        tgtURL = SVNRepositoryFactory.createLocalRepository( new File( path ), true , false );
    }

    @After
    public void tearDown() throws IOException {
        FileUtils.deleteDirectory(new File(path));
    }

    @Test
    public void test() {
        fail("Not yet implemented");
    }

}