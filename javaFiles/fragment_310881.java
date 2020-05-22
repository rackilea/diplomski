import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.stage.Stage;

import java.io.IOException;

public class JavaTaskClass extends Application{

       public static void main(String[] args) { 
         launch(args); 
       }

      @Override public void start(final Stage stage) throws IOException {
        //create task object
        Task<Integer> task = new Task<Integer>(){

          @Override
          protected Integer call() throws Exception{
            System.out.println("Background task started...");
            int iterations;
            for(iterations = 0; iterations < 10000; iterations++){
              if(isCancelled()){
                break;
              }
              System.out.println("Iteration " + iterations);
              Thread.sleep(3000);
            }
            return iterations;
          }
        };

        //start the background task
        Thread th = new Thread(task);
        th.setDaemon(true);
        System.out.println("Starting background task...");
        th.start();
    }

}