package MyApp;

import MyApp.Variables.Constants;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    private Image icon;

    public Main() {
      icon = new Image(Main.class.getResource("/img/appicon.png").toExternalForm());
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Forms/FormMain.fxml"));

        primaryStage.getIcons().add(icon);
        primaryStage.setTitle("MyApp " + Constants.VERSION_NAME + " (" + Constants.RELEASE_ID + ")"); 
        primaryStage.setScene(new Scene(root, 1000, 800));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}