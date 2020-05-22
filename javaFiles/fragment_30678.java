package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class MainJavaFX extends Application {
@Override
public void start(Stage stage) throws Exception {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("Document.fxml"));
    AnchorPane root = loader.load();
    Scene scene = new Scene(root);

    stage.setScene(scene);
    stage.show();
   }

/**
 * @param args the command line arguments
 */
public static void main(String[] args) {
    launch(args);
}
}