public class ServiceInvocationHandler implements InvocationHandler {
    private final Object proxied;
    private SignedTicket ticket;

    public ServiceInvocationHandler(Object proxied) {
        this.proxied = proxied;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        Object retVal = null;
        try {
            // Generate a ticket if the one held locally by this class is null
            // and inject it in the method arguments
            retVal = method.invoke(proxied, args);
        } catch (Throwable t) {
            if (t.getCause() instanceof InvalidTicketException) {
                // Get a fresh ticket and inject it in the method arguments
                retVal = method.invoke(proxied, args);
            }
        }    
        return retVal;
    }
}