@ApplicationPath("/rest")
public class JsonApplication extends Application  {
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<Class<?>>();
        classes.add(JsonResource.class);
        return classes;
    }
}