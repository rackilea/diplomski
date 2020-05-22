import java.util.Random;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LongRunningTaskExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        CheckBox enabled = new CheckBox("Enabled");
        enabled.setDisable(true);
        CheckBox activated = new CheckBox("Activated");
        activated.setDisable(true);
        Label name = new Label();
        Label value = new Label();

        Label serviceStatus = new Label();

        StatusService service = new StatusService();
        serviceStatus.textProperty().bind(service.messageProperty());

        service.valueProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue == null) {
                enabled.setSelected(false);
                activated.setSelected(false);
                name.setText("");
                value.setText("");
            } else {
                enabled.setSelected(newValue.isEnabled());
                activated.setSelected(newValue.isActivated());
                name.setText(newValue.getName());
                value.setText("Value: "+newValue.getValue());
            }
        });

        Button startStop = new Button();
        startStop.textProperty().bind(Bindings
                .when(service.runningProperty())
                .then("Stop")
                .otherwise("Start"));

        startStop.setOnAction(e -> {
            if (service.isRunning()) {
                service.cancel() ;
            } else {
                service.restart();
            }
        });

        VBox root = new VBox(5, serviceStatus, name, value, enabled, activated, startStop);
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private static class StatusService extends Service<Status> {
        @Override
        protected Task<Status> createTask() {
            return new Task<Status>() {
                @Override
                protected Status call() throws Exception {
                    Random rng = new Random();
                    updateMessage("Running");
                    while (! isCancelled()) {

                        // mimic sporadic data feed:
                        try {
                            Thread.sleep(rng.nextInt(2000));
                        } catch (InterruptedException exc) {
                            Thread.currentThread().interrupt();
                            if (isCancelled()) {
                                break ;
                            }
                        }

                        Status status = new Status("Status "+rng.nextInt(100), 
                                rng.nextInt(100), rng.nextBoolean(), rng.nextBoolean());
                        updateValue(status);
                    }
                    updateMessage("Cancelled");
                    return null ;
                }
            };
        }
    }

    private static class Status {
        private final boolean enabled ; 
        private final boolean activated ;
        private final String name ;
        private final int value ;

        public Status(String name, int value, boolean enabled, boolean activated) {
            this.name = name ;
            this.value = value ;
            this.enabled = enabled ;
            this.activated = activated ;
        }

        public boolean isEnabled() {
            return enabled;
        }

        public boolean isActivated() {
            return activated;
        }

        public String getName() {
            return name;
        }

        public int getValue() {
            return value;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}