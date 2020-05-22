import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class ReportGeneratorTest {

    //This is executed before each @Test, generally is used for prepare the ambient, instantiate services, start servers and so on.
    @Before
    public void setUp() throws IOException {
        report = MyReportService.createReport();
    }

    //This is executed after each @Test generally this used for tear down your servers or data bases, or delete all the records inserted
    @After
    public void tearDown() {
        MyReportService.deleteById(10);
    }

    @Test
    public void verifyInsertion() throws Exception {
        //Here you can verify that the record of your serive or logic it's ok
        assertTrue(MyReportService.getLastId() > 10); //Or whatever
    }
}