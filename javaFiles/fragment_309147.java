@Stateless(name="MySchedulerBean)
public class MySchedulerBean
     private boolean cancelTimer = false;

     public void stopDiscovery() {
        this.cancelTimer = true;
     }

     @Schedule(persistent=false, minute="*/2", hour="*", timezone="GMT"
     public void discover(Timer timer) {
          if (cancelTimer) {
               timer.cancel();
               return;
          }
          //run discovery
     } 
}