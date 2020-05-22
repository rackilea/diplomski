public class ProductGuideApplication extends Application
{
    private Set<Object> singletons = new HashSet<Object>();
    private Set<Class<?>> classes = new HashSet<Class<?>>();

    public ProductGuideApplication() 
    { 
        singletons.add(new CSVMessageBodyWriter());
        classes.add(FooResource.class);
    }

    @Override
    public Set<Object> getSingletons()
    { 
        return singletons;
    }

    @Override
    public Set<Class<?>> getClasses() 
    {
        return classes;
    }
}