import java.io.*;
import java.net.URL;
import java.util.*;
import java.util.logging.*;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;

/**
 *
 * @author blj0011
 */
public class FXMLDocumentController implements Initializable
{    
    @FXML private Button btnMain;  

    Stage window;

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {

        // TODO
        btnMain.setOnAction(e -> {
            ((Stage)((Node)e.getSource()).getScene().getWindow()).hide();           
            popUpDisplay();
            ((Stage)((Node)e.getSource()).getScene().getWindow()).show();

        });
    }    

    public void popUpDisplay()
    {
        try
        {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SceneTwo.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            //stage.initStyle(StageStyle.UNDECORATED);
            stage.setTitle("PopUp");
            stage.setScene(new Scene(root1));
            stage.showAndWait();
        }
        catch (IOException ex)
        {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}