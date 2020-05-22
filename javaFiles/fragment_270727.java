import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import netscape.javascript.JSObject;

public class TextFlowHyperlinkTest extends Application {


    private final static String TEXT = 
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, "
            + "sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. "
            + "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris "
            + "nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in "
            + "reprehenderit in voluptate velit esse cillum dolore eu "
            + "fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, "
            + "sunt in culpa qui officia deserunt mollit anim id est laborum." ;

    @Override
    public void start(Stage primaryStage) {
        TextFlow textFlow = new TextFlow();

        for (String word : TEXT.split("\\s")) {
            // arbitraily make some words hyperlinks:
            if (word.length() == 6) {
                Hyperlink hyperlink = new Hyperlink(word);
                hyperlink.setOnAction(e -> System.out.println("Click on "+word));
                textFlow.getChildren().add(hyperlink);
            } else {
                textFlow.getChildren().add(new Text(word+" "));
            }
        }

        ScrollPane textFlowScroller = new ScrollPane(textFlow);
        textFlowScroller.setFitToWidth(true);
        textFlowScroller.setMinHeight(200);
        VBox.setVgrow(textFlowScroller, Priority.ALWAYS);

        WebView webView = new WebView();
        WebEngine engine = webView.getEngine();
        engine.documentProperty().addListener((obs, oldDoc, newDoc) -> {
            if (newDoc != null) {
                JSObject window = (JSObject) engine.executeScript("window");
                window.setMember("app", this);
            }
        });
        StringBuilder html = new StringBuilder();
        html.append("<html><body><div name='text'>");
        for (String word : TEXT.split("\\s")) {
            if (word.length() == 6) {
                html.append("<a href='#' onclick='app.process(\""+word+"\")'>")
                    .append(word).append("</a> ");
            } else {
                html.append(word).append(" ");
            }
        }
        html.append("</div></body></html>");
        engine.loadContent(html.toString());

        VBox.setVgrow(webView, Priority.ALWAYS);


        Scene scene = new Scene(new VBox(10, textFlowScroller, webView), 400, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void process(String text) {
        System.out.println("Click on "+text);
    }

    public static void main(String[] args) {
        launch(args);
    }
}