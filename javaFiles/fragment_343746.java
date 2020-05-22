public class MyApp extends Application 
{
    @Override
    public Set<Class<?>> getClasses() 
    {
        HashSet<Class<?>> set = new HashSet<Class<?>>(2);
        set.add(JacksonConfig.class);
        set.add(MyService.class);
        return set;
    }
}