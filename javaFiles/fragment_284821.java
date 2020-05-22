import javafx.application.Application;
import javafx.css.PseudoClass;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class TextAreaWithCentering extends Application {

    @Override
    public void start(Stage primaryStage) {

        TextArea textArea = new TextArea();

        PseudoClass centered = PseudoClass.getPseudoClass("centered");

        ToggleButton center = new ToggleButton("Center");
        center.selectedProperty().addListener((obs, wasCentered, isNowCentered) -> 
                textArea.pseudoClassStateChanged(centered, isNowCentered));

        BorderPane.setAlignment(center, Pos.CENTER);
        BorderPane.setMargin(center, new Insets(5));
        BorderPane root = new BorderPane(textArea, null, null, center, null);

        Scene scene = new Scene(root, 600, 600);

        scene.getStylesheets().add("centering-text-area.css");

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}