import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;


public class MyController implements Initializable{
    @FXML Label labelVar;
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        labelVar.setText(labelVar.getText() + MyClass.getMyVariable());

    }

}