package application;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
public class Main extends Application 
{    
BorderPane root = new BorderPane();
Button btn=new Button("Click Here");
Stage primaryStage;
Scene scene ;
public Main()
{
    btn.setPrefWidth(75);
    btn.setPrefHeight(15);

    btn.setOnAction((e)->
    {
        SubClass s=new SubClass(primaryStage);
    });
}

@Override
public void start(Stage primaryStage)
{
    try {
        this.primaryStage=primaryStage;
        //          root.getChildren().add(btn);

        scene = initStage();
        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    } catch(Exception e)
    {
        e.printStackTrace();
    }
}

private Scene initStage()
{
    root.setCenter(btn);
    return new Scene(root,150,150);
}


public static void main(String[] args) {
    launch(args);
}
}