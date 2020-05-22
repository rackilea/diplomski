public class Global extends GlobalSettings {

    @Override
    public void onStart(Application app) {
           Akka.system().scheduler().scheduleOnce(
               Duration.create(10, TimeUnit.MILLISECONDS),
               new Runnable() {
                    public void run() {
                        // Do startup stuff here
                        initializationTask();
                    }
               },
               Akka.system().dispatcher()
           );
      }  
 }