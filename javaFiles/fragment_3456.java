import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TextFieldFireEvent extends Application {

    @Override
    public void start(Stage primaryStage) {
        TextField tf = new TextField() {
            {
                setSkin(createDefaultSkin());
            }
        };

        Button button = new Button("A");
        button.setOnAction(e -> {
            KeyEvent ke = new KeyEvent(KeyEvent.KEY_TYPED, 
                    "a", "", 
                    KeyCode.UNDEFINED, false, false, false, false);
                tf.fireEvent(ke);
                System.out.println(tf.getText());
        });
        VBox root =new VBox(10, /*tf,*/ button);

        root.setAlignment(Pos.CENTER);
        primaryStage.setScene(new Scene(root, 400, 400));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}