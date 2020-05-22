import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ABCTest {
    @DataProvider
    public Object[] one() {
        return new Object[] { 1 };
    }

    @BeforeMethod
    public void setUp(Object[] params) {
        System.out.println("setUp execution");
        Assert.assertEquals(params[0], 1);
    }

    @Test(dataProvider = "one")
    public void test(Integer intParam) {
        System.out.println("test execution");
    }
}