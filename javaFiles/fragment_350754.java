package tictactoe3d;

import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class PageController {

    @FXML
    private List<Button> buttons ;

    private int page ;

    public void setPage(int page) {
        this.page = page ;
    }

    public void initialize() {
        for (int i = 0; i < buttons.size(); i++) {
            Button button = buttons.get(i);
            int row = i % 4 ;
            int column = i / 4 ;
            button.setOnAction(e -> {
                button.setText("R");
                // replace with real data update:
                System.out.println("Button pressed on page "+page+" row "+row+" column "+column);
            });
        }
    }

}