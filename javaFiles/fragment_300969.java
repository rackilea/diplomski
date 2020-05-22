package mvpc;
import javafx.fxml.FXML;

public class Controller {

    @FXML
    private PresentationModel model ;

    @FXML
    private void increment() {
        model.increment();
    }
}