@Service
public class ServiceB{
  public void doTheJob(ServiceA serviceA) {
    Executors.newSingleThreadExecutor().execute(() -> {/*do some job*/ 
                                                  serviceA.jobDone(););
  }
}