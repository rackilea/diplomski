@ApplicationPath("/api")
public class YourApplication extends Application {
    private Set<Class<?>> classes = new HashSet<>();
    private Set<Object> singletons = new HashSet<>();

    public YourApplication() {
        classes.add(AuthorizationRequestFilter.class);
    }
    @Override
    public Set<Class<?>> getClasses() {
        return classes;
    }
    @Override
    public Set<Object> singletons() {
        return singletons;
    }
}