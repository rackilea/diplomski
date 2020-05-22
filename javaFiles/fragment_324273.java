package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class WebViewTest extends Application {

    @Override
    public void start(Stage primaryStage) {
        WebView webView = new WebView();
        WebEngine engine = webView.getEngine();

        Label output = new Label();

        Bridge bridge = new Bridge(engine);

        engine.load(getClass().getResource("/resources/First.html").toExternalForm());

        Button first = new Button("Load First");
        first.setOnAction(e -> engine.load(getClass().getResource("/resources/First.html").toExternalForm()));

        Button second = new Button("Load Second");
        second.setOnAction(e -> engine.load(getClass().getResource("/resources/Second.html").toExternalForm()));

        TextField textField = new TextField();
        Button button = new Button("Send");
        EventHandler<ActionEvent> handler = e -> {
            bridge.execute(result -> output.setText(result.toString()),
                    "showText", textField.getText());
            textField.setText("");
        };
        button.setOnAction(handler);
        textField.setOnAction(handler);

        HBox controls = new HBox(5, first, second, textField, button, new Label("Web page says: "), output);
        controls.setPadding(new Insets(10));

        BorderPane root = new BorderPane(webView, null, null, controls, null);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }



    public static void main(String[] args) {
        launch(args);
    }
}