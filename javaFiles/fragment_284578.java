public class MdcInterceptor {

    @AroundInvoke
    public Object addMdcValue(InvocationContext context) throws Exception {
        MDC.put("cid", RandomStringUtils.randomAlphanumeric(16));
        try {
            return context.proceed();
        } finaly {
            MDC.remove("cid");
        }
    }
}