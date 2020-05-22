import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestClass extends AbstractBaseClass {
    @Test(dataProvider = "getData")
    public void testMethod(String testname, int count) {
        Assert.assertNotNull(testname);
        Assert.assertTrue(count > 0);
    }

    @DataProvider
    public Object[][] getData() {
        return new Object[][]{
                {"LoginTestCase", 100},
                {"ComposeMailTestcase", 200}
        };
    }
}