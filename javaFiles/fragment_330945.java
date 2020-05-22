import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Arrays ;


public class testMain extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        VBox root = new VBox(5);

        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(10, 5, 10, 5));

        Scene scene = new Scene(root);

        ComboBox<String> cb = new ComboBox<>();
        cb.getItems().addAll("content 1" , "content 2",  "content 3");

        Label label = new Label("shows content");

        cb.valueProperty().addListener((observable, oldValue, newValue) -> {

            root.getChildren().removeIf(node -> node != cb);
            Label newLabel = new Label(newValue);
            root.getChildren().addAll(0, Arrays.asList(newLabel));
        });

        root.getChildren().addAll(label, cb);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}