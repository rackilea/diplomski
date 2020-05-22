package application;

import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class SomeOtherController {

    private final DataModel model ;

    @FXML
    private Label userLabel ;

    public SomeOtherController(DataModel model) {
        this.model = model ;
    }

    public void initialize() {

        // Use EasyBind https://github.com/TomasMikula/EasyBind for
        // more robust binding to a "property of a property"

        userLabel.textProperty().bind(Bindings.select(model.currentUserProperty(), "userName"));
    }
}