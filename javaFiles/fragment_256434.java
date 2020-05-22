import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class Pirate extends Application {

    public static final String CHROME_41_USER_AGENT =
            "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/41.0.2228.0 Safari/537.36";

    @Override
    public void start(final Stage stage) throws Exception {
        WebView webView = new WebView();
        webView.getEngine().setUserAgent(
                CHROME_41_USER_AGENT
        );
        webView.getEngine().load("http://mp3skull.com");

        stage.setScene(new Scene(webView));
        stage.show();
    }
    public static void main(String[] args) throws Exception {
        launch(args);
    }
}