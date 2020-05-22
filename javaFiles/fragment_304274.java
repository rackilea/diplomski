import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Controller {

    @FXML
    ReelPane reel;
    @FXML
    Button spin;

    public void initialize() {

        spin.setOnAction(event -> {
            reel.spin();
            spin.setDisable(true);
        });
    }
}