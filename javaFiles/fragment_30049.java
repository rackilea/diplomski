import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.testng.IDataProviderListener;
import org.testng.IDataProviderMethod;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener2;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;

public class CustomListen implements IInvokedMethodListener2, IDataProviderListener {

    private static Method savedDataProviderMethod = null;

    @Override
    public void afterDataProviderExecution(IDataProviderMethod dataProviderMethod, ITestNGMethod testNGMethod, ITestContext context) {
        System.out.println(">> afterDataProviderExecution start");
        savedDataProviderMethod = dataProviderMethod.getMethod();
        System.out.println("<< afterDataProviderExecution end");
    }

    @Override public void beforeDataProviderExecution(IDataProviderMethod dataProviderMethod, ITestNGMethod testNGMethod, ITestContext context) {}

    @Override public void afterInvocation(IInvokedMethod method, ITestResult testResult) {}
    @Override public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {}
    @Override public void afterInvocation(IInvokedMethod method, ITestResult testResult, ITestContext context) {}

    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult, ITestContext context) {
        System.out.println(">> beforeInvocation start");
        // Method customMethod = // code to find custtom method;
        try {
            Object[] params = (Object[]) savedDataProviderMethod.invoke(testResult.getInstance());

            for (Object param : params) {
                System.out.println("Dataprovider return data --" + param);
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        // customMethod.invokeMethod(testResult.getInstance(), params);
        System.out.println("<< beforeInvocation end");
    }
}