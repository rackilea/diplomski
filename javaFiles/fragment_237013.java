import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

public class FirstUI  {

    @FXML Pane main;

    public void changeScene(ActionEvent e) {
        try {
            main.getScene().setRoot(new FXMLLoader().load(getClass().getResource("/res/screenTwo.fxml")));
        } catch (Exception ex) {
          ex.printStackTrace();
        }
    }
}