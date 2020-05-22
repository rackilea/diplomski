import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.TextFormatter.Change;
import javafx.stage.Stage;

public class TextAreaFixedStartEndLines extends Application {

    private final String start = "function collideWith(mobj, tar, dir) {\n";
    private final String end = "\n}";

    @Override
    public void start(Stage primaryStage) {
        TextArea textArea = new TextArea();
        textArea.setTextFormatter(new TextFormatter<String>((Change c) -> {
            String proposed = c.getControlNewText();
            if (proposed.startsWith(start) && proposed.endsWith(end)) {
                return  c;
            } else {
                return null ;
            }
        }));

        textArea.setText(start+"\n"+end);

        primaryStage.setScene(new Scene(textArea, 600, 600));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}