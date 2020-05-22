import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class EditableWebView extends Application {

    @Override
    public void start(Stage primaryStage) {
        WebView webView = new WebView();
        webView.getEngine().loadContent(
            "<html><body contentEditable=\"true\"></body></html>");

        Button contentButton = new Button("Show content");
        contentButton.setOnAction(e -> {
            List<String> lines = new ArrayList<>();

            Node body = webView.getEngine()
                    .getDocument()
                    .getElementsByTagName("body")
                    .item(0);
            NodeList childNodes = body.getChildNodes();
            for (int i=0; i<childNodes.getLength(); i++) {
                lines.add(childNodes.item(i).getTextContent());
            }

            lines.forEach(System.out::println);

        });

        Button htmlButton = new Button("Show HTML");
        htmlButton.setOnAction(e -> 
            System.out.println(webView.getEngine()
                    .executeScript("document.documentElement.innerHTML")));

        HBox buttons = new HBox(5, contentButton, htmlButton);

        BorderPane root = new BorderPane(webView, null, null, buttons, null);
        Scene scene = new Scene(root, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}