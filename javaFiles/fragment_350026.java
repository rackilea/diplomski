import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FirstTestClass {

    @Test(dataProvider = "getData")
    public void testMethod(String param) {
        System.out.println("Name = " + param);
    }

    @DataProvider
    public Object[][] getData(ITestContext context) {
        String parameter = context.getCurrentXmlTest().getLocalParameters().get("names");
        String[] names = parameter.split(",");
        Object[][] returnValues = new Object[names.length][1];
        int index = 0;
        for (Object[] each : returnValues) {
            each[0] = names[index++].trim();
        }
        return returnValues;
    }
}