package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.stage.Stage;

public class Main extends Application {    
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent main = FXMLLoader.load(getClass().getResource("launcher.fxml"));

        primaryStage.setTitle("Dev Launcher");
        primaryStage.setWidth(900);
        primaryStage.setHeight(560);

        Scene scene = new Scene(main);

        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}