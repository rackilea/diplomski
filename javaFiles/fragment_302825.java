@ManagedBean
@ApplicationScoped
public class InspectorBean{

    public boolean inspectMethod(String className, String methodName){
        return inspect(Class.forName(className).getMethod(methodName));
    }

}