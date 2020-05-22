import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LoadOwnFXML extends Application {

    @Override
    public void start(Stage primaryStage) {


            Scene scene = new Scene(new ProfilPane());
            primaryStage.setTitle("Hello World!");
            primaryStage.setScene(scene);
            primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}