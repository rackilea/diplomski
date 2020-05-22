package org.test;

import java.io.File;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class FileChooserDemo extends Application {

    public FileChooserDemo() {};

    public static void main(String[] args) throws ClassNotFoundException {
        FileChooserDemo.launch(FileChooserDemo.class); 
    }

    public void chooseFileAndPrintRelativePath() {
        FileChooser photo = new FileChooser();
        Stage stage = new Stage();
        stage.setTitle("File Chooser Sample");
        Button openButton = new Button("Choose file");
        openButton.setOnAction((t) -> {
            File file = photo.showOpenDialog(stage);
            if (file != null) {
                String cwd = System. getProperty("user.dir");
                System.out.println(new File(cwd).toURI().relativize(file.toURI()).getPath());
            }
        });
        //Creating a Grid Pane 
        GridPane gridPane = new GridPane();    
        //Setting size for the pane 
        gridPane.setMinSize(400, 200);
        gridPane.add(openButton, 0, 0); 
        Scene scene = new Scene(gridPane);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        chooseFileAndPrintRelativePath();
    }

}