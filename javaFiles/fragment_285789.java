import javafx.application.Application;
import javafx.scene.Scene ;
import javafx.scene.layout.StackPane ;
import javafx.scene.control.Label ;
import javafx.stage.Stage ;

import java.util.logging.Level;
import java.util.logging.Logger;


public class Worker extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
        StackPane root = new StackPane(new Label("Hello World"));
        Scene scene = new Scene(root, 350, 75);
        primaryStage.setScene(scene);
        primaryStage.show();
        doit();
    }

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    private void doit(){

        try {
            IteratingTask mytask = new IteratingTask(800000);
            // mytask.call();
            Thread backgroundThread = new Thread(mytask);
            backgroundThread.start(); // will return immediately, task runs in background
            System.out.println(mytask.getValue());
             int pro = (int) mytask.getProgress();
        System.out.println(pro);
        } catch (Exception ex) {
            Logger.getLogger(Worker.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}