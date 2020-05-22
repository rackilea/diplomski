package com.example;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

  @Override
  public void start(Stage primaryStage) throws IOException {
    Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/App.fxml")));
    primaryStage.setScene(scene);
    primaryStage.setTitle("FileChooser Example");
    primaryStage.show();
  }

}