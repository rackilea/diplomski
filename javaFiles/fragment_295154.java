public class Activator implements BundleActivator {
    private ServiceRegistration serviceRegistration;

    @Override
    public void start( BundleContext context ) {
        this.serviceRegistration = context.registerService(
            MyInterface.class,
            new MyImpl(), new HashMap<String,String>());
    }

    @Override
    public void stop( BundleContext context ) {
        if (serviceRegistration!=null) {
            serviceRegistration.unregister();
        }
    }
}