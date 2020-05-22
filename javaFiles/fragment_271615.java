package application;

import javafx.application.Application;
import javafx.application.Preloader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void init() throws InterruptedException{
        //Simulation of time consuming code.
        for(int i = 0; i<=10; i++) {
            notifyPreloader(new Preloader.ProgressNotification(i/10.0));
            System.out.println("Progress is being set by the app to: " + (i/10.0));
            Thread.sleep(500);
        }
        notifyPreloader(new Preloader.StateChangeNotification(Preloader.StateChangeNotification.Type.BEFORE_START));
    }

    @Override
    public void start(Stage primaryStage) {
        Parent root;
            root = new StackPane(new Label("Hello World"));
            Scene scene = new Scene(root, 600, 400);

            primaryStage.setScene(scene);
            primaryStage.setTitle("Hello World!");
            primaryStage.show();

    }

}