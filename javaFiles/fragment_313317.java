import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

public class ProfilPane extends AnchorPane {

    public ProfilPane() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("my.fxml"));
            loader.setRoot(this);
            loader.setController(this);
            loader.load();
        } catch (IOException ex) {
            Logger.getLogger(ProfilPane.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    public void select() {
        System.out.println("selected");
    }

    @FXML
    public void hoverOver() {
        System.out.println("hovered");
    }

    @FXML
    public void hoverOut() {
        System.out.println("hovered out");
    }
}