package project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Luncher extends Application
{


    @Override
    public void start(Stage primaryStage) {
        try {


            Parent root = FXMLLoader.load(getClass().getResource("Window.fxml"));

            Scene scene = new Scene(root);          

            primaryStage.setScene(scene);
            primaryStage.show();

        } catch(Exception e) {
            System.err.println("Luncher Failed !" +e);
        }
    }

    public static void main(String[] args) 
    {

        launch(args);

    }

}