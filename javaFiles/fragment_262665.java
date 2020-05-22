package javafxpopup;

import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXPopup;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Menai Ala Eddine
 */
public class JavaFXPopup extends Application {

    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction((ActionEvent event) -> {
            buildContextMenu().show(btn);
        });

        StackPane root = new StackPane();
        root.getChildren().add(btn);

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    public JFXPopup buildContextMenu() {
        JFXPopup contextPop = new JFXPopup();      
        contextPop.setPopupContent(getItemsList());
        return contextPop;
    }

    private VBox getItemsList() {
        VBox boxItem = new VBox();
        Label addItem = new Label("Add File");
        Label editItem = new Label("Edit File");
        Label deleteItem = new Label("Delete File");
        boxItem.getChildren().addAll(addItem, editItem, deleteItem);
        return boxItem;

    }

}