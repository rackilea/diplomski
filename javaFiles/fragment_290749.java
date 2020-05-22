@Path("...")
public class UserResource {
    @Inject
    private UserDBHandler handler;
}

@ApplicationPath("..")
public class MyApplication extends Application {
    private Set<Class<?>> classes = new HashSet<>();

    public MyApplication() {
        classes.add(UserResource.class);
        singletons.add(new AppBinder());
    }

    @Override
    public Set<Class<?>> getClasses() {
        return classes;
    }

    class AppBinder extends org.glassfish.hk2.utilities.binding.AbstractBinder {
        @Override
        public void configure() {
            bind(UserDBHandler.class).to(UserDBHandler.class);
        }
    }
}