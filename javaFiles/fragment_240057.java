import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.stage.Stage;

public class Main extends Application implements Initializable {

    @FXML
    private TreeView<String> managertree;

    TreeItem<String> rootItem = new TreeItem<>("Manager");

    @Override
    public void start(Stage stage) throws IOException {

        //Load FXML file
        Parent root = FXMLLoader.load(getClass().getResource("MainLayout.fxml"));

        //...
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("jLog");
        rootItem.setExpanded(true);
        for (int i = 1; i < 6; i++) {
            TreeItem<String> item = new TreeItem<String>("Managing Logs " + i);
            rootItem.getChildren().add(item);
        }

        //Show the Stage
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Main Controller initialized.....");

        managertree.setRoot(rootItem);
        managertree.setShowRoot(false);

    }

}