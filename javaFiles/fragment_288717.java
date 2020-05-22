import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class NonIterruptableTaskCancellation extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        ServerSocket socket = new ServerSocket(2048);

        Task<Void> task = new Task<Void>() {
            @Override
            protected Void call() throws Exception {

                while (! isCancelled()) {
                    try {
                        Socket s = socket.accept();
                        System.out.println("Connected to "+s);
                        s.close();
                    } catch (IOException exc) {
                        if (isCancelled()) {
                            System.out.println("Cancelled");
                        } else {
                            System.out.println("Unexpected IO Exception");
                            throw exc ;
                        }
                    }
                }

                return null ;
            }

            @Override
            protected void cancelled() {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread t = new Thread(task);
        t.setDaemon(true);
        t.start();

        Label label = new Label();
        label.textProperty().bind(task.stateProperty().asString());

        Button cancel = new Button("Cancel");
        cancel.disableProperty().bind(task.runningProperty().not());
        cancel.setOnAction(e -> task.cancel());

        VBox root = new VBox(5, label, cancel);
        root.setPadding(new Insets(10));
        root.setAlignment(Pos.CENTER);

        Scene scene = new Scene(root, 200, 120);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}