import java.util.Arrays;
import java.util.List;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.controlsfx.control.textfield.AutoCompletionBinding;
import org.controlsfx.control.textfield.TextFields;

/**
 *
 * @author blj0011
 */
public class JavaFXApplication208 extends Application
{

    AutoCompletionBinding<String> abcBinding;
    AutoCompletionBinding<String> defBinding;

    @Override
    public void start(Stage primaryStage)
    {

        List<String> list1 = Arrays.asList("one", "two", "three");
        List<String> list2 = Arrays.asList("four", "five", "six");

        TextField textfield = new TextField();

        VBox root = new VBox();

        RadioButton radioButton1 = new RadioButton("Left");
        RadioButton radioButton2 = new RadioButton("Right");

        ToggleGroup radioGroup = new ToggleGroup();
        radioButton1.setToggleGroup(radioGroup);
        radioButton2.setToggleGroup(radioGroup);
        radioGroup.selectedToggleProperty().addListener((obs, oldValue, newValue) -> {
            RadioButton tempRadioButton = (RadioButton) newValue;
            if (tempRadioButton == radioButton1) {
                if (defBinding != null) {
                    defBinding.dispose();
                }
                abcBinding = TextFields.bindAutoCompletion(textfield, list1);
            }
            else if (tempRadioButton == radioButton2) {
                if (abcBinding != null) {
                    abcBinding.dispose();
                }
                defBinding = TextFields.bindAutoCompletion(textfield, list2);
            }
        });

        HBox hbox = new HBox(radioButton1, radioButton2);

        root.getChildren().addAll(hbox, textfield);

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        launch(args);
    }

}