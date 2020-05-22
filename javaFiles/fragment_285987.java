@Stateless
public class MyController{

 @Produces
 public MyService getMyService(){
  return new MyService();
 }
}