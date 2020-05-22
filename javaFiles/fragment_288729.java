import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.controlsfx.control.textfield.TextFields;

/**
 *
 * @author blj0011
 */
public class JavaFXApplication193 extends Application
{

    @Override
    public void start(Stage primaryStage)
    {
        List<String> list = new ArrayList();
        list.add("Max");
        list.add("moon");
        list.add("am");
        list.add("two");

        TextField textFieldSearch = new TextField();
        TextFields.bindAutoCompletion(textFieldSearch, t -> {
            return list.stream().filter(elem
                    -> {
                return elem.toLowerCase().startsWith(t.getUserText().toLowerCase());
            }).collect(Collectors.toList());
        });

        StackPane root = new StackPane(textFieldSearch);
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