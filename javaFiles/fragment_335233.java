package click.webelement.testng;

import org.testng.Assert;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({TListenerTest.class})
public class TListenerTest implements ITestListener {

    @Test
    public void toFail(){
        Assert.assertTrue(false);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println(result.getInstance().getClass().getSimpleName());
        System.out.println(result.getTestClass().getClass().getSimpleName());
    }
}