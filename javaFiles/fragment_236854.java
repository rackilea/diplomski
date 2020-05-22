import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import java.util.Map;

public class InterceptorsBean {

    private Map<String, Integer> numberOfInvocations;

    @AroundInvoke
    public Object methodInterceptors (InvocationContext ctx) throws Exception {
        int invocations = 1;

        if(numberOfInvocations.containsKey(ctx.getMethod().getName())) {
           invocations = numberOfInvocations.get(ctx.getMethod().getName()) + 1;
        }

        numberOfInvocations.put(ctx.getMethod().getName(), invocations);

        System.out.println("Method invocated: " + ctx.getMethod().getName());
        System.out.println("Number of invocations: " + invocations);
        return ctx.proceed();
    }

}