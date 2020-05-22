@ApplicationPath("..")
public class MyApplication extends Application {
    private Set<Class<?>> classes = new HashSet<>();
    private Set<Object> singletons = new HashSet<>();

    public MyApplication() {
        singletons.add(new UserResource(new UserDBHandler()));
    }

    @Override
    public Set<Class<?>> getClasses() {
        return classes;
    }

    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }
}