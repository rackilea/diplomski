public class Activator implements BundleActivator
{
    private volatile LoggerFactory loggerFactory;

    public void start(BundleContext context) throws Exception 
    {   
        ServiceReference ref = context.getServiceReference(LoggerFactory.class.getName());
        if (ref != null)
        {
            loggerFactory = (LoggerFactory) context.getService(ref);
        }
    }

    //..