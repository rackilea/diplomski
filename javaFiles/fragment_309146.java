@Stateless(name="MySchedulerBean)
public class MySchedulerBean
     private boolean cancelTimer = false;

     public void stopDiscovery() {
        this.cancelTimer = true;
     }

     @Schedule(persistent=false, minute="*/2", hour="*", timezone="GMT"
     public void discover() {
          if (cancelTimer) {
               return;
          }
          //run discovery
     } 
}