package perso.tests.timer;

import java.util.Timer;
import java.util.TimerTask;

public class TimerExample  extends TimerTask{

      Timer timer;
      int executionsPerSecond;

      public TimerExample(int executionsPerSecond){
          this.executionsPerSecond = executionsPerSecond;
        timer = new Timer();
        long period = 1000/executionsPerSecond;
        timer.schedule(this, 200, period);
      }

      public void functionToRepeat(){
          System.out.println(executionsPerSecond);
      }
        public void run() {
          functionToRepeat();
        }   
      public static void main(String args[]) {
        System.out.println("About to schedule task.");
        new TimerExample(3);
        new TimerExample(6);
        new TimerExample(9);
        System.out.println("Tasks scheduled.");
      }
}