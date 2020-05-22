import javafx.fxml.FXML;
import javafx.scene.Parent;

public class MainController{

    @FXML private Parent includedView; //not used in this demo
    /*
     * Get a reference to IncludedView controller simply by appending
     * the word Controller in addition to the variable name of the embedded
     * element:$IncludedView;+Controller
     */
    @FXML private IncludedViewController includedViewController;

    @FXML private void handleTestBtn() {
        includedViewController.showAlert();
    }
}