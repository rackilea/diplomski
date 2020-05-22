package tictactoe3d;

import javafx.fxml.FXML;

public class GameController {
    @FXML
    private PageController page0Controller ;
    @FXML
    private PageController page1Controller ;
    @FXML
    private PageController page2Controller ;
    @FXML
    private PageController page3Controller ;

    public void initialize() {
        page0Controller.setPage(0);
        page1Controller.setPage(1);
        page2Controller.setPage(2);
        page3Controller.setPage(3);
    }
}