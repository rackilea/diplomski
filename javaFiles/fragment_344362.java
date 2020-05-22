import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.stage.*;

/**
 * FXML Controller class
 *
 * @author blj0011
 */
public class SceneTwoController implements Initializable
{
    @FXML Button btnClosePopup;    

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // TODO
        btnClosePopup.setOnAction(e -> {
            ((Stage)(((Button)e.getSource()).getScene().getWindow())).close();           
        });
    }    

}