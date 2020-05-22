import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Tab1Controller implements TabController {

    @FXML
    private Button btnTestController;

    @FXML
    private void initialize() {

        // Set our button to print out which controller is being used
        btnTestController.setOnAction(event -> System.out.println("Hello, from Controller #1!"));

    }
}