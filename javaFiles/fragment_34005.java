public class CustomSmartEndpointInterceptor extends Wss4jSecurityInterceptor implements SmartEndpointInterceptor {

    //CustomEndpoint is your @Endpoint class
    @Override
    public boolean shouldIntercept(MessageContext messageContext, Object endpoint) {
        if (endpoint instanceof MethodEndpoint) {
            MethodEndpoint methodEndpoint = (MethodEndpoint)endpoint;
            return methodEndpoint.getMethod().getDeclaringClass() == CustomEndpoint.class; 
        }
        return false;
    }
}