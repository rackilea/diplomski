package mvpc;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Presenter {

    @FXML
    private PresentationModel model ;

    @FXML
    private Label display ;

    public void initialize() {
        display.textProperty().bind(model.countProperty().asString("Count: %d"));
    }
}