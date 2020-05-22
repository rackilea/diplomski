public class AnalyticsMethodsClassPathLoader {

private JarClassLoader jcl;
private JclObjectFactory factory;

public AnalyticsMethodsClassPathLoader(String analyticsMethodsJarsFolder) {

    //JCL object for loading jars
    jcl = new JarClassLoader();
    //Loading classes from different sources
    jcl.add(analyticsMethodsJarsFolder);

    // Set ClassPathLoader priorities to prevent collisions when loading
    jcl.getParentLoader().setOrder(1);
    jcl.getLocalLoader().setOrder(2);
    jcl.getSystemLoader().setOrder(3);
    jcl.getThreadLoader().setOrder(4);
    jcl.getCurrentLoader().setOrder(5);

    // Set default to cglib (from version 2.2.1)
    ProxyProviderFactory.setDefaultProxyProvider( new CglibProxyProvider() );
    factory = JclObjectFactory.getInstance(true);
}

public AnalyticsMethod loadClass(String implementingClass) throws AnalyticsMethodLoaderException {
    //Create object of loaded class
    AnalyticsMethod abstractMethod;
    try{
        abstractMethod = (AnalyticsMethod) factory.create(jcl, implementingClass);
        return abstractMethod;
    }
    catch (JclException e)
    {
        e.printStackTrace();
        throw new AnalyticsMethodLoaderException("The class " + implementingClass +
                " was not found or does not implement the framework.");
    }
    catch (java.lang.NoSuchMethodError error)
    {
        error.printStackTrace();
        throw new AnalyticsMethodLoaderException("The class " + implementingClass +
                " does not have an empty constructor.");
    }
}