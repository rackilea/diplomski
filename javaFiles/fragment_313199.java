import javafx.application.Application;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Test extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    private Label labelInfo;
    private Button button;
    private ProgressIndicator progressIndicator;

    @Override
    public void start(Stage stage) throws Exception {
        VBox vbox = new VBox(5);
        vbox.setAlignment(Pos.CENTER);
        labelInfo = new Label();
        button = new Button("Restart");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                buttonClicked(event);
            }
        });
        progressIndicator = new ProgressIndicator(-1);
        progressIndicator.setVisible(false);
        vbox.getChildren().addAll(labelInfo, progressIndicator, button);

        Scene scene = new Scene(vbox, 300, 200);
        stage.setScene(scene);
        stage.show();
    }

    void buttonClicked(ActionEvent e) {
        Service<Void> service = new Service<Void>() {
            @Override
            protected Task<Void> createTask() {
                return new Task<Void>() {
                    @Override
                    protected Void call() throws Exception {
                        updateMessage("restarting - might take a few seconds");
                        // Here the blocking operation
                        // jBoss.restart();
                        Thread.sleep(10000);
                        updateMessage("JBoss successfully restarted");
                        return null;
                    }
                };
            }
        };
        // Make the progress indicator visible while running
        progressIndicator.visibleProperty().bind(service.runningProperty());
        // Bind the message of the service to text of the label
        labelInfo.textProperty().bind(service.messageProperty());
        // Disable the button, to prevent more clicks during the execution of
        // the service
        button.disableProperty().bind(service.runningProperty());
        service.start();
    }
}