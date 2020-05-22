import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

/**
 *
 * @author blj0011
 */
public class FXMLDocumentController implements Initializable
{

    @FXML
    private TextField texto;


    //Use this approach to replace most of your private button handlers!
    @FXML
    private void handleButtonAction(ActionEvent event)
    {
        Button button = (Button)event.getSource();
        texto.appendText(button.getText());
    }

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // TODO
    }      
}