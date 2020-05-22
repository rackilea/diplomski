import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class NodeTemplateController{

    @FXML
    Label content;

    void setContent(String txt){
        content.setText(txt);
    }
}