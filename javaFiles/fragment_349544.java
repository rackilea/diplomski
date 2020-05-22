public class ShutdownHookBean implements Runnable {

    private final MyService service;

    //MyService wired in by spring, (could be @Autowired etc).
    public ShutdownHookBean(MyService service) {

         this.service = service;

         Runtime.getRuntime().addShutdownHook(this);

    }

    public void run() {
          service.performShutdown();
    }

}