import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ToggleSetup extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        RadioButton on = new RadioButton("on");
        RadioButton off = new RadioButton("off");
        ToggleGroup toggleState = new ToggleGroup();
        on.setToggleGroup(toggleState);
        off.setToggleGroup(toggleState);
        toggleState.selectToggle(on);

        VBox sliderPane = new VBox(
                10,
                new Slider(),
                new Slider(),
                new Slider()
        );

        sliderPane.disableProperty().bind(
                Bindings.equal(off, toggleState.selectedToggleProperty())
        );

        VBox layout = new VBox(10, on, off, sliderPane);
        layout.setPadding(new Insets(10));
        stage.setScene(new Scene(layout));
        stage.show();
    }

    public static void main(String[] args) { launch(args); }
}