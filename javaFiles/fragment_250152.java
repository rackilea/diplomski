@Service
public class ServiceA{
   ServiceB serviceB;
  @Autowired      
  public ServiceA(ServiceB serviceB){
     this.serviceB = serviceB;
  }

  void foo(){
    serviceB.doTheJob();         
  }
 void jobDone() {
 {
}