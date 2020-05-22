import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Strikeout extends Application {

    @Override 
    public void start(Stage stage) throws Exception {
        Button strikethrough = new Button("Strikethrough");
        strikethrough.getStylesheets().addAll(getClass().getResource(
                "strikethrough.css"
        ).toExternalForm());

        StackPane layout = new StackPane(
                strikethrough
        );
        layout.setPadding(new Insets(10));
        stage.setScene(new Scene(layout));

        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}