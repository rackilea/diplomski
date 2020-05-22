import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.GridPane;
import java.net.URL;
import java.util.ResourceBundle;

public class TheatreController implements Initializable {

    @FXML
    private GridPane middleGridPane;

    private final int MAX_ROW = 5;
    private final int MAX_COL = 5;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        int countRow = 1;
        ToggleButton[][] seats = new ToggleButton[MAX_ROW][MAX_COL];

        char lastRow = 'A' + (MAX_ROW - 1);

        for(char row = 'A'; row < lastRow; row++){
            for (int col = 1; col < MAX_COL; col++){
                seats[countRow][col] = new ToggleButton(String.format(row + "%02d", col));
                seats[countRow][col].setPrefWidth(50);
                middleGridPane.add(seats[countRow][col], countRow, col);

                //effectively final variable to use in handle method of EventHandler
                int finalCountRow = countRow;
                int finalCol      = col;

                seats[countRow][col].setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {

                        //now you can get text from seats[finalCountRow][finalCol]
                        System.out.println(seats[finalCountRow][finalCol].getText());
                        event.getEventType().getName();
                    }
                });
            }
            countRow++;
        }
    }

    @FXML
    public void bookSeat(){

    }
}