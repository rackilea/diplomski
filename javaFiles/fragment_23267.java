@ApplicationPath("/api")
public class RestApplication extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<>();
        classes.add(AuthenticationFilter.class);
        classes.add(RolesAllowedFeature.class);
        classes.add(SomeResource.class);
        return classes;
    }
}