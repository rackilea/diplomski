import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class FXMLDocumentController implements Initializable {

    @FXML Pane p1;
    @FXML Pane p2;
    @FXML Pane p3;
    @FXML Button p1next;
    @FXML Button p2next;
    @FXML Button p2previous;
    @FXML Button p3previous;

    public void initialize(URL url, ResourceBundle rb) 
    {
        p1next.setOnAction(e->{ p1.setVisible(false); p2.setVisible(true); });
        p2next.setOnAction(e->{ p2.setVisible(false); p3.setVisible(true); });
        p2previous.setOnAction(e->{ p2.setVisible(false); p1.setVisible(true); });
        p3previous.setOnAction(e->{ p3.setVisible(false); p2.setVisible(true); });
    }  
}