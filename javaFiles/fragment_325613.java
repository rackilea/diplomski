import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Graphics extends Application {

    private Button b1;
    @Override
    public void start(Stage stage) {

        GridPane gp = new GridPane();       
        b1 = new Button();
        b1.setPrefSize(50, 50);
        gp.add(b1, 2, 2);   

        Scene scene = new Scene(gp, 230, 250);
        stage.setTitle("TicTacToe");
        stage.setScene(scene);
        stage.show();     
    }

    public Button getButton(){return b1;}
}

class TicTacToe {

    Graphics g;
    public TicTacToe() {

        //If you don't want to create Graphics here, get a reference to it 
        g = new Graphics();
    }

    public void game() {

        g.getButton().setOnAction(new EventHandler<ActionEvent>() { 
            @Override
            public void handle(ActionEvent event) {
                //do what you need 
            }
        });
    }
}