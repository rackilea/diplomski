public class YourInterceptor extends AbstractSoapInterceptor {
    public YourInterceptor() {
        super(Phase.INVOKE);
        addBefore(Arrays.asList(ServiceInvokerInterceptor.class.getName()));
        // This means handleMessage will be called juste before your @WebMethod
        // If it fails, you will be the first to be noticed through #handleFault()
    }
}