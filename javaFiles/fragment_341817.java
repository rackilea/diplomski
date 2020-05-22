package javatest;

import java.util.Timer;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.concurrent.Worker;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Driver extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {

            TextArea console = new TextArea();
            BorderPane root = new BorderPane(console);
            Scene scene = new Scene(root, 600, 400);
            primaryStage.setScene(scene);
            primaryStage.show();

            Task<Void> myTask = new TestStopMethod();
            Timer t = new Timer();
            Watchdog w = new Watchdog(myTask);
            t.schedule(w, 1000);
            Thread mythread = new Thread(myTask);
            mythread.setDaemon(true);

            myTask.stateProperty().addListener((obs, oldState, newState) -> {
                console.appendText("State change "+oldState+" -> "+newState+"\n");
                if (oldState == Worker.State.RUNNING) {
                    t.cancel();
                    console.appendText("End of Story\n");
                }
            });
            mythread.start();

        } catch (Exception ex) {
            Logger.getLogger(Driver.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}