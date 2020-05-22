package countdown.gui;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JavaFXCountdownApp extends Application {

    @Override
    public void start(Stage primaryStage) {

        ProgressBar progressBar = new ProgressBar(0);
        Label label =  new Label() ;
        TextField timeTextField = new TextField();
        timeTextField.setOnAction(e -> {
            CountdownTask countdownTask = new CountdownTask(Integer.parseInt(timeTextField.getText()));
            progressBar.progressProperty().bind(countdownTask.progressProperty());
            countdownTask.setOnSucceeded(evt -> label.setText("Timer finished!"));
            Thread t = new Thread(countdownTask);
            t.setDaemon(true);
            t.start();
        });

        VBox root = new VBox(5, timeTextField, progressBar, label);
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}