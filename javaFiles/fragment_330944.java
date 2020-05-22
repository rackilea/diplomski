import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane ;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class TestMain extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {


        VBox vbox = new VBox(5);

        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(10, 5, 10, 5));

        BorderPane root = new BorderPane(vbox);

        Scene scene = new Scene(root);

        ComboBox<String> cb = new ComboBox<>();
        root.setBottom(cb);

        cb.getItems().addAll("content 1" , "content 2",  "content 3");

        Label label = new Label("shows content");

        cb.valueProperty().addListener((observable, oldValue, newValue) -> {

            vbox.getChildren().clear();
            Label newLabel = new Label(newValue);
            vbox.getChildren().addAll(newLabel);
        });

        vbox.getChildren().addAll(label);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}