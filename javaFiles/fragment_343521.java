package exitfrommenu;

import javafx.fxml.FXML;
import javafx.scene.control.MenuBar;

public class MainController {
    @FXML
    private MenuBar menuBar ;

    @FXML
    private void exit() {
            Stage stage = (Stage) menuBar.getScene().getWindow() ;
            // This exits the application, but of course you can do anything
            // you like with the stage, such as showing a new scene in it:
        stage.hide();
    }
}