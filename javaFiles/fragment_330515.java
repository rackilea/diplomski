import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.control.Button;

public class main extends Application{

    @Override public void start(Stage primaryStage) {
        Button button1 = new Button("Button 1");
        Button button2 = new Button("Button 2");

        button1.setOnAction(event -> {
            // This code is executed when button1 is pressed
            if(button2.isVisible())
                button2.setVisible(false);
            else button2.setVisible(true);
        });

        button2.setOnAction(event -> {
            // This code is executed when button2 is pressed
            if(button1.isVisible())
                button1.setVisible(false);
            else button1.setVisible(true);
        });

        button2.setLayoutX(75);

        Group root = new Group(button1, button2);
        Scene scene = new Scene(root, 200, 150);
        primaryStage.setScene(scene);
        primaryStage.setWidth(200);
        primaryStage.setHeight(150);
        primaryStage.show();
    }

    public static void main(String[] args){
        launch();
    }
}