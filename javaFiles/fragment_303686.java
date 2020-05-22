import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class SomeSpecificServiceInterceptor implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        String status;
        try {
            // allow the original invocation to actually execute
            status = String.valueOf(invocation.proceed());
        } catch (IllegalStateException e) {
            System.out.println("Existing service threw the following exception [" + e.getMessage() + "]");
            status = "FAIL";
        }
        return status;
    }
}