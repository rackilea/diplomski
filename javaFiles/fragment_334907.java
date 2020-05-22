public class BServiceImplementation implements BService {

private ExecutorService executorService;

private CService cservice;

public void bindCService(CService service) {
    cservice = service;
    System.out.println("bundle gateway bound to b service");
}

public void bindExecutorService(ExecutorService executorService) {
    this.executorService = executorService;
}

public void unbindCService(CService service) {
    this.cservice = null;
}

public void transmitIn(final int id) {
    executorService.submit(new Runnable() {
        @Override
        public void run() {
            process(id);
        }
    });
}

public void process(int id) {
    // Lots of processing happens here
}
}