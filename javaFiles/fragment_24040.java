// It is my main class Factory provides with file's number required for xpath to open it and go further:
public class AllTablesTest extends BaseTest {
    // It is the main thing I added to get it worked within factory:
    private int fNumber;
    public AllTablesTest(int fileNumber) {
        this.fNumber = fileNumber;
    }
    ........
}

// WebTestFactory class I get from TestNG documentation and changed it to get desirable number of files:
public class WebTestFactory extends BaseTest{
    int numberOfFiles;

    @Factory
    public Object[] createInstances() throws Exception {
        getDriver("Chrome");
        getUrl("adminUrl");
        login(getValue("adminEmail"),getValue("adminPass"));
        numberOfFiles = getNumberOfFiles();
        Object[] result = new Object[numberOfFiles];
        for (int i=0; i<numberOfFiles; i++) {
            result[i]=new AllTablesTest(i+1);
        }
        return result;
    }