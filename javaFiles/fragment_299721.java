@Stateless
public class MyBean {

   @EJB(name = "ejb/PlaceBid")
   private MyService myService;

}