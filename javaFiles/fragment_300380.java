import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RadioButtonListener extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        // Simple Interface
        VBox root = new VBox(10);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(10));

        // Create the toggle group
        ToggleGroup group = new ToggleGroup();

        // Create two radio buttons
        RadioButton rdo1 = new RadioButton("One");
        RadioButton rdo2 = new RadioButton("Two");

        // Add them to the ToggleGroup
        group.getToggles().addAll(rdo1, rdo2);

        // Add a listener to the ToggleGroup to determine when a selection has changed
        group.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.equals(rdo1)) {
                System.out.println("ONE selected");
            } else if (newValue.equals(rdo2)) {
                System.out.println("TWO selected");
            }
        });

        // Add the RadioButtons to the stage
        root.getChildren().addAll(rdo1, rdo2);

        // Show the stage
        primaryStage.setScene(new Scene(root));
        primaryStage.setTitle("Sample");
        primaryStage.show();
    }
}