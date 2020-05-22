import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controller {

    // Declare the controls used in the FXML file
    @FXML
    private Button button1;
    @FXML
    private Button button2;
    @FXML
    private Button button3;
    @FXML
    private Label lblSource;

    // This method is called when any of the buttons in the FXML file is clicked
    // The "ActionEvent" parameter includes all the details of the event that calls this method
    @FXML
    void handleClick(ActionEvent event) {

        // Assuming only a Button will call this method, determine which button it was by retrieving the Source of
        // the event.
        Button sourceButton = (Button) event.getSource();

        // We have the source, so let's update the label to show the text of the Button that was clicked.
        lblSource.setText(sourceButton.getText());
    }
}