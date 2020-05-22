import java.awt.event.ActionListener;

// rename class to begin with an uppercase letter
public class MyTimer{
int delay = 1000; //milliseconds
  ActionListener taskPerformer = new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
          //...Perform a task...
       }
 }; 

 public MyTimer() {
   // the code below is now happily placed inside of your class's constructor.
   new Timer(delay, taskPerformer).start(); 
 }

}