import org.testng.annotations.BeforeMethod;

public class AbstractBaseClass {
    @BeforeMethod
    public void beforeMethod(Object[] parameters) {
        //Here we are assuming that the testname will always be the first parameter
        //in the 1D array that gets sent for every iteration of @Test method
        if (parameters != null && parameters.length >= 1) {
            String testname = parameters[0].toString();
            System.out.println("Test name obtained in beforeMethod() " + testname);
        }
    }
}