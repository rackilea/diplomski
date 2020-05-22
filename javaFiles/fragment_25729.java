import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

public class Controler implements Initializable {

    @FXML
    private TextField msg_tb;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        msg_tb.textProperty().addListener((obs, oldText, newText) -> {
            System.out.println("Text changed from "+ oldText +" to "+newText);
        });
    }
}