import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;


public class FXMLDocumentController implements Initializable {

    @FXML
    private WebView webView;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                String html = "<html>\n"
                        + "<head>\n"
                        + "<title>jQuery Hello World</title>\n"
                        + " \n"
                        + "<script type=\"text/javascript\" src=\"http://code.jquery.com/jquery-1.2.6.min.js\"></script>\n"
                        + " \n"
                        + "</head>\n"
                        + " \n"
                        + "<body>\n"
                        + " \n"
                        + "<script type=\"text/javascript\">\n"
                        + " \n"
                        + "$(document).ready(function(){\n"
                        + " $(\"#msgid\").html(\"Hello World by JQuery\");\n"
                        + "});\n"
                        + " \n"
                        + "</script>\n"
                        + " \n"
                        + "Hello World by HTML\n"
                        + " \n"
                        + "<div id=\"msgid\">\n"
                        + "</div>\n"
                        + " \n"
                        + "</body>\n"
                        + "</html>";

                webView.getEngine().loadContent(html);
            }
        });

    }

}