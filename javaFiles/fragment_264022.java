@ManagedResource(objectName="bean:name=process", description="Process Bean")
public class Process {

   private int delay;

   @ManagedAttribute(description="The delay attribute")
   public int getDelay() {
      return delay;
   }

   public void setDelay(int delay) {
      this.delay = delay;
   }

   public void doIt(){
      int x = getDelay();
   }
}