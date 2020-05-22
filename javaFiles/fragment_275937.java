@ApplicationPath("/rest")
public class TextApplication extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        final Set<Class<?>> classes = new HashSet<>();
        classes.add(JsonResource.class);
        classes.add(TextMessageBodyWriter.class);
        return classes;
    }
}