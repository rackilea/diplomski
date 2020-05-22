import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.web.HTMLEditor;
import javafx.stage.Stage;

public class SpacedOut extends Application {

    private static final String HTML_TEXT =
            "<p style=\"line-height:1.5\">\n" +
            "    <span style=\"font-size:12pt\">The quick brown fox jumps over the lazy dog.</span><br />\n" +
            "    <span style=\"font-size:24pt\">The quick brown fox jumps over the lazy dog.</span>\n" +
            "</p>";

    @Override
    public void start(Stage stage) throws Exception{
        HTMLEditor editor = new HTMLEditor();
        editor.setHtmlText(HTML_TEXT);

        Scene scene = new Scene(new Pane(editor));
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}