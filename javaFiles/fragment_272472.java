@WebService
public class WebServiceDelegateToXXXServer implements XXXInterface{

   public WebServiceDelegateToXXXServer(XXXInterface actualImplementor){
       this.actualImplementor = actualImplementor;
   }

   public Result doStuff1(String param1){
       return actualImplementor.doStuff1(param1);
   }
}