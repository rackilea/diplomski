package sample;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
@Override
public void start(Stage primaryStage) throws Exception{
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(Main.class.getResource("sample.fxml"));
    Parent root = loader.load();
    primaryStage.setTitle("Hello World");
    primaryStage.setScene(new Scene(root, 300, 275));
    primaryStage.show();

    Controller controller = loader.getController();

    controller.setLabel("Test");
//  Or
//  controller.getLabel().setText("Test");
 }
public static void main(String[] args) {
    launch(args);
 }
}