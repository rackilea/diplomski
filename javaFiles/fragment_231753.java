import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;

public class MainController implements Initializable    {

    @FXML private Parent IncludedView;
    @FXML private InputController IncludedViewController; // $IncludedView;+Controller

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        System.out.println(IncludedView.getClass());
        System.out.println(IncludedViewController.getClass()    );
    }

    @FXML private void handleExitBtn() {
        System.exit(0);
    }
}