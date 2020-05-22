import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{

    @FXML private Label category1;
    @FXML private GridPane root;

    @Override
    public void initialize(URL location, ResourceBundle resources){
        category1.setFocusTraversable(true);
        root.setOnKeyPressed(this::handle);
    }

    private void handle(KeyEvent keyEvent){
        category1.setText("Key " + keyEvent.getCode().getName() + " is pressed");
    }

}