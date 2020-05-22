import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FXMLMain extends Application {

    public static void main(String[] args) {
        //you should know this but this is how you launch your application
        Application.launch(FXMLMain.class, args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("loginLayout.fxml"));

        stage.setTitle("Login");
        stage.setScene(new Scene(root, 600, 475));
        stage.show();
    }
}