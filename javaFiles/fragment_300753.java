import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBoxBuilder;
import javafx.stage.Stage;

public class StyleDemo extends Application {

    @Override
    public void start(Stage primaryStage) {
        final Label lbl = new Label("Style Me");
        lbl.getStyleClass().add("style1"); // initial style

        Button btn = new Button("Change the style");
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                lbl.getStyleClass().remove("style1");
                lbl.getStyleClass().add("style2");
            }
        });

        StackPane root = new StackPane();
        root.getChildren().add(VBoxBuilder.create().spacing(20).children(lbl, btn).build());
        Scene scene = new Scene(root, 300, 250);
        scene.getStylesheets().add(this.getClass().getResource("style.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}