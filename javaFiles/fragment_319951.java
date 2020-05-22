@Stateless
public class BeanService {

   @Context
   ContainerRequestContext containerRequestContext;

   public void doStuff() {
      // <- get data from request
   }
}