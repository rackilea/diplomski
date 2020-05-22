import org.testng.IHookCallBack;
import org.testng.IHookable;
import org.testng.ITestResult;
import org.testng.annotations.Test;

public class MyTestClass implements IHookable {
    @Override
    public void run(IHookCallBack callBack, ITestResult testResult) {
        callBack.runTestMethod(testResult);
        commonTestCode();
    }

    public void commonTestCode() {
        System.err.println("commonTestCode() executed.");

    }

    @Test
    public void testMethod1() {
        System.err.println("testMethod1() executed.");
    }

    @Test
    public void testMethod2() {
        System.err.println("testMethod2() executed.");
    }
}