@ApplicationPath("/api/*")
public class ApplicationConfig extends Application {
    private final Set<Class<?>> classes = new HashSet<>();
    private final Set<Object> singletons = new HashSet<>();

    public ApplicationConfig() {
        classes.add(MyMessageBodyReader.class);
        singletons.add(new MyMessageBodyReader());
    }

    @Override
    public Set<Class<?>> getClasses() {
        return this.classes;
    }

    @Override
    public Set<Object> getSingletons() {
        return this.singletons;
    }
}