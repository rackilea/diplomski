import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ButtonPanelController {

    @FXML
    Button myButton;

    boolean isRed = false;

    private Model model ;

    public ButtonPanelController(Model model) {
        this.model = model ;
    }

    public void initialize() {

        myButton.styleProperty().bind(Bindings.
                when(model.redProperty()).
                then("-fx-background-color: red;").
                otherwise("")
        );
    }

    public void buttonClickedAction(ActionEvent event) {
        model.toggleRed();
    }
}