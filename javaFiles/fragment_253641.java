import java.util.Scanner;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class LabelUpdateTest extends Application {

    private Label label;

    @Override
    public void start(Stage stage) throws Exception {
        label = new Label("Waiting for input..");
        stage.setScene(new Scene(label, 100, 100));
        stage.show();

        initInputThread();
    }

    private void initInputThread() {

        Scanner input = new Scanner(System.in);

        Task<Void> task = new Task<Void>() {
            @Override
            protected Void call() {
                while (true) {
                    String userInput = input.nextLine();

                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            label.setText("Input was : " + userInput);
                        }
                    });

                }
            }
        };

        Thread th = new Thread(task);
        th.setDaemon(true);
        th.start();
    }

    public static void main(String[] args) {
        launch(args);
    }
}