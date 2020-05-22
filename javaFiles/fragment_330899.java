import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.ProgressIndicator;

public class Controller {

    @FXML
    private ProgressIndicator progressIndicator;

    public void initialize() {
        final ServiceExample serviceExample = new ServiceExample();

        //Here you tell your progress indicator is visible only when the service is runing
        progressIndicator.visibleProperty().bind(serviceExample.runningProperty());
        serviceExample.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
            @Override
            public void handle(WorkerStateEvent workerStateEvent) {
                String result = serviceExample.getValue();   //here you get the return value of your service
            }
        });

        serviceExample.setOnFailed(new EventHandler<WorkerStateEvent>() {
            @Override
            public void handle(WorkerStateEvent workerStateEvent) {
                //DO stuff on failed
            }
        });
        serviceExample.restart(); //here you start your service
    }
}