@ApplicationPath("/services")
public class WSApplication extends Application {
    private Set<Object> singletons = new HashSet<Object>();
    private Set<Class<?>> classes = new HashSet<Class<?>>();
    public WSApplication() {
        ...
        classes.add(AddressXmlValidationReader.class);
        ...
    }
    ...
}