@Service
public class ServiceB{
   ServiceB serviceA;
  @Autowired      
  public ServiceA(ServiceA serviceA){
     this.serviceA = serviceA;
  }

  public void doTheJob() {
    Executors.newSingleThreadExecutor().execute(() -> {/*do some job*/ 
                                                  serviceA.jobDone(););
  }

}