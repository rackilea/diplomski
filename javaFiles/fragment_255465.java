public class Binder extends AbstractBinder {
    @Override
    protected void configure() {
        ...
        bindFactory(ListServiceFactory.class).to(new TypeLiteral<List<Service>>(){});
    }  
}

public static class ListServiceFactory implements Factory<List<Service>> {

    @Inject
    private IterableProvider<Service> services;

    @Override
    public List<Service> provide() {
        return Lists.newArrayList(services);
    }

    @Override
    public void dispose(List<Service> t) {}
}