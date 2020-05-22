import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Callback;

public class TestApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        // 1st Stage
        stage.setTitle("1st Stage");
        stage.setWidth(200);
        stage.setHeight(200);
        stage.setResizable(false);

        // The one and only model we will use for both views and controllers:
        Model model = new Model();

        /* Override the ControllerFactory callback to create 
         * the controller using the model:
         */
        Callback<Class<?>, Object> controllerFactory = type -> {
            if(type == ButtonPanelController.class) {
                return new ButtonPanelController(model);
            } else {
                try {
                    return type.newInstance();
                } catch(Exception e) {
                    throw new RuntimeException(e);
                }
            }
        };

        // Load FXML
        FXMLLoader loader = new FXMLLoader(
                ButtonPanelController.class.getResource("ButtonPanel.fxml"));
        loader.setControllerFactory(controllerFactory);

        Parent root = (Parent) loader.load();

        // Show 1st Scene
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        // 2nd Stage
        Stage stage2 = new Stage();
        stage2.setTitle("2nd Stage");
        stage2.setWidth(200);
        stage2.setHeight(200);
        stage2.setResizable(false);

        // Load FXML
        FXMLLoader loader2 = new FXMLLoader(
                ButtonPanelController.class.getResource("ButtonPanel.fxml"));
        // Set the ControllerFactory before the load takes place
        loader2.setControllerFactory(controllerFactory);
        Parent root2 = (Parent) loader2.load();

        // Show 2nd Scene
        Scene scene2 = new Scene(root2);
        stage2.setScene(scene2);
        stage2.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}