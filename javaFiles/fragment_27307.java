import javafx.application.Application;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.stage.Stage;


public class ServiceTest extends Application{

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Service<Void> service = new Service<Void>() {
            @Override
            protected Task<Void> createTask() {
                return null;
            }
        };
        service.setOnFailed(event ->
            System.out.println(event.getSource().getException().toString()));
    }

}