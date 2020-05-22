import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author blj0011
 */
public class FXMLDocumentController implements Initializable
{
    //Tab1 nodes
    @FXML private Label lblTab1;
    @FXML private TextField tfTab1;

    //Tab2 nodes
    @FXML private Label lblTab2;
    @FXML private TextField tfTab2;


    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        //This code set the Tab1 label's text to what is show in the TextField on Tab1
        tfTab1.setOnKeyReleased((event)->{
            lblTab1.setText(tfTab1.getText());
        });

        //This code set the Tab2 label's text to what is show in the TextField on Tab2
        tfTab2.setOnKeyReleased((event)->{
            lblTab2.setText(tfTab2.getText());
        });
    }    

}