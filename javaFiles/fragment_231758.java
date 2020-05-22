import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class IncludedViewController{

    void showAlert(){
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setContentText("Alert invoked by IncludedViewController ");
        alert.show();
    }
}