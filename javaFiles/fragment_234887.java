import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.Path;
import org.reflections.Reflections;

public class ResourceClassHelper {

    private static Set<Class<?>> resourceClasses;

    public static Set<Class<?>> getResourceClasses() {
        if (resourceClasses != null) {
            return resourceClasses;
        }

        // the package to scan for @Path classes "com.example"
        Reflections reflections = new Reflections("com.example");

        resourceClasses = reflections.getTypesAnnotatedWith(Path.class);
        resourceClasses = Collections.unmodifiableSet(resourceClasses);
        return resourceClasses;
    }
}