public class LoggingInterceptor {
    ...

    @AroundInvoke
    public Object modifyGreeting(InvocationContext ctx) throws Exception {
        ....
        Object[] parameters = ctx.getParameters();
        try {
            return ctx.proceed();
        } catch (Exception e) {
            logger.warning("Error calling ctx.proceed in modifyGreeting()");
            return null;
        }
    }
}