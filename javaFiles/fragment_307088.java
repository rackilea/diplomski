import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class GUI extends Application {
    //Sets up window
    @Override
    public void start(Stage primaryStage)throws IOException {
        primaryStage.setTitle("Table View Test");
        Parent root = FXMLLoader.load(getClass().getResource("tvTest.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setResizable(true);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}