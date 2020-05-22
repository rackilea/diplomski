package tictactoe3d;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class GameController {

    @FXML
    private GridPane page0 ;
    @FXML
    private GridPane page1 ;
    @FXML
    private GridPane page2 ;
    @FXML
    private GridPane page3 ;

    public void initialize() {
        GridPane[] pages = {page0, page1, page2, page3};

        for (int page = 0; page < 4; page++) {
            for (int row = 0; row < 4; row ++) {
                for (int col = 0; col < 4; col++) {
                    Button button = new Button("O");
                    pages[page].add(button, col, row);

                    String message = "Button pressed on page "+page+" row "+row+" column "+col;
                    button.setOnAction(e -> {
                        button.setText("R");
                        // replace with real data update:
                        System.out.println(message);
                    });
                }
            }
        }
    }
}