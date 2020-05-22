package javasocket;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;

public class Controller {

    VBox msg_vbox = new VBox();

    @FXML
    ScrollPane scrlpane;

    @FXML
    TextField message;

    @FXML
    protected void sendMessage() {

        //new label text with message.
        Label set_text = new Label();
        set_text.setText("Server Says: \n" + message.getText());
        set_text.setStyle("-fx-padding:10;"
                +"-fx-width:100%;"
                + "-fx-background-color:teal;"
                + "    -fx-background-insets: 5;"
                + "-fx-font-size:15;"
                + "-fx-background-radius: 3;");

        set_text.setPrefSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
        set_text.setWrapText(true);
        set_text.setTextAlignment(TextAlignment.JUSTIFY);
        set_text.setPrefWidth(600);


        //VBox wrapper
        msg_vbox.getChildren().addAll(set_text);
        msg_vbox.setPrefWidth(600);

        //Further wrapped by ScrollPane
        scrlpane.fitToHeightProperty();
        scrlpane.setContent(msg_vbox);
        scrlpane.vvalueProperty().bind(msg_vbox.heightProperty()); //sets the scroll view to new element.
        message.setText("");



    }

    @FXML
    protected void check_key(KeyEvent ae) {

        if (ae.getCode().equals(KeyCode.ENTER)) {
            sendMessage();
        }
    }
}