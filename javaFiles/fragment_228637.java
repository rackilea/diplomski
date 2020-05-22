import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class WebViewInTextFlow extends Application {

    @Override
    public void start(Stage primaryStage) {
        TextFlow flow = new TextFlow();

        WebView webView = new WebView();
        webView.getEngine().getLoadWorker().stateProperty().addListener((obs, oldState, newState) -> System.out.println(newState));
        webView.getEngine().load("http://stackoverflow.com/questions/31353921/is-webview-embeddable-in-textflow/31357609#31357609");


        flow.getChildren().addAll(new Text("Some text"), new Group(webView), new Text("Some more text"));

        primaryStage.setScene(new Scene(flow, 800, 800));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}