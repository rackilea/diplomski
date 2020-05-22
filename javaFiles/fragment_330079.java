public class BrokerHandler {

    @Inject
    // the services you need

    @Execute 
    public void execute(IEclipseContext context, @Named(IServiceConstants.ACTIVE_SHELL) Shell shell)
            throws InvocationTargetException, InterruptedException {
        // do some stuff
    }
}