@javax.ws.rs.ApplicationPath("/api")
public class RestApplication extends javax.ws.rs.core.Application {
     @Override
     public Set<Class<?>> getClasess() {
         Set<Class<?>> classes = new HashSet<>();
         classes.add(Hello.class);
         return classes;
     }
}