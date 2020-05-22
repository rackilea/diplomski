new AgentBuilder.Default()
 .rebase(declaresMethod(isAnnotatedWith(Monitor.class))
 .transform( (builder, type) ->
   builder
     .method(isAnnotatedWith(Monitor.class))
     .intercept(MethodDelegation.to(MonitorInterceptor.class);
  );

class MonitorInterceptor {
  @RuntimeType
  Object intercept(@Origin String method,
                                @SuperCall Callable<?> zuper)
      throws Exception {
    long start = System.currentTimeMillis();
    try {
       return zuper.call();
     } finally {
       System.out.println(method + " took " + (System.currentTimeMillis() - start);
     }
   }
}