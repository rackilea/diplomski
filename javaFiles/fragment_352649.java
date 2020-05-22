package application;

import javafx.application.Application; 
import static javafx.application.Application.launch; 
import javafx.geometry.Insets; 
import javafx.geometry.Pos; 

import javafx.scene.Scene; 
import javafx.scene.control.Button; 
import javafx.scene.control.PasswordField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane; 
import javafx.scene.text.Text; 
import javafx.scene.control.TextField; 
import javafx.stage.Stage;  


public class Main extends Application {
@Override
public void start(Stage primaryStage) {
    try {
        BorderPane root = new BorderPane();
        Button button2 = new Button("Clear"); 

        // this method is used to set the button to the top of the screen, check the documentation to get the other methods
        root.setTop(button2);

        Scene scene = new Scene(root,400,400);
        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    } catch(Exception e) {
        e.printStackTrace();
    }


}

public static void main(String[] args) {
    launch(args);
}
}