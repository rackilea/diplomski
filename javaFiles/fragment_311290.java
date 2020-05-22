public class MyRESTApp 
     extends Application  {
    @Override
public Set<Class<?>> getClasses() {
        Set<Class<?>> s = new HashSet<Class<?>>();
        s.add(MyMessageBodyReader.class);
        return s;
    }
}