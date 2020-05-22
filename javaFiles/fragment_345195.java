package sample;

import javafx.application.Application; 
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Sample extends Application {

//    private String[] answers = {"rock", "paper", "scissors"};
//    private TextField userOutputTF, compOutputTF;
//    private Button goButton;
//    private Label title;
//    private VBox pane;

    @Override
    public void start(Stage primaryStage) throws Exception {
    Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

    primaryStage.setTitle("Hello World");
    primaryStage.setScene(new Scene(root, 500, 500));
    primaryStage.setTitle("Rock, Paper, Scissors");

    VBox pane = new VBox();
    pane.setAlignment(Pos.CENTER);

    String[] answers = {"rock", "paper", "scissors"};

    Button goButton = new Button("Go");
    pane.getChildren().add(goButton);

    TextField userOutputTF = new TextField("Enter rock, paper, or scissors");
    TextField compOutputTF = new TextField("");

    compOutputTF.setEditable(false);
    userOutputTF.setEditable(true);

    goButton.onMouseClickedProperty().addListener((obs, oldValue, newValue) -> {
        System.out.println("Handled Lambda listener");
        System.out.println("Have fun!");
    });

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }


    public void Deal() {
        System.out.println("Hi");
    }
}