public class MyInterceptor extends AbstractInterceptor {
   ...
    public String intercept(ActionInvocation invocation) throws Exception {
       invocation.addPreResultListener(new PreResultListener() {
            public void beforeResult(ActionInvocation invocation, 
                                     String resultCode) {
                // perform operation necessary before Result execution
            }
       });
    }
   ...
}