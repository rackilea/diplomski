import java.io.IOException;
import javafx.fxml.FXML;

public class Controller {

    @FXML
    private void handleLoadButton() throws IOException {
        myMain.handleLoadButton();
    }

    private Main myMain;

    public void setMain(Main myMain) {
        this.myMain = myMain;
    }

}