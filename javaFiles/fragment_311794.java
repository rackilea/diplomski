public class Target{

private Timer timer;

   ...

   public void displayFor(int seconds) {
     // send the output
     BoardInterface.SetDigitalChannel(this.getId());

     // calculate the delay
     long time = seconds * 1000;

     // create a new timer and schedule the new task
     timer = new Timer();
     timer.schedule(new TargetTimer(this), time);

     this.setDisplayed(true);
  }
}

class TargetTimer extends TimerTask{
   Target target;

   public TargetTimer(Target t){
       this.target = t;
   }

   @Override
   public void run() {
       target.destroy();
   }

}