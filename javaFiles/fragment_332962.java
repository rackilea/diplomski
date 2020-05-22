import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class DynamicWebViewTest extends Application {

    @Override
    public void start(Stage primaryStage) {
        WebView webView = new WebView();
        webView.getEngine().loadContent("<html><body><table border='1' id='table'>"+
                    "<tr><th>Name</th><th>Value</th></tr></table></body></html>");

        TextField nameTF = new TextField();
        TextField valueTF = new TextField();
        Button addRowButton = new Button("Add row");
        addRowButton.setOnAction(event -> {
           Document doc = webView.getEngine().getDocument();
           Element table = doc.getElementById("table");
           Element newRow = doc.createElement("tr");
           Element nameCell = doc.createElement("td");
           Element valueCell = doc.createElement("td");
           nameCell.appendChild(doc.createTextNode(nameTF.getText()));
           valueCell.appendChild(doc.createTextNode(valueTF.getText()));
           newRow.appendChild(nameCell);
           newRow.appendChild(valueCell);
           table.appendChild(newRow);

           nameTF.setText("");
           valueTF.setText("");
        });

        HBox controls = new HBox(5, nameTF, valueTF, addRowButton);
        controls.setAlignment(Pos.CENTER);
        controls.setPadding(new Insets(5));

        BorderPane root = new BorderPane(webView, null, null, controls, null);
        Scene scene = new Scene(root, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}