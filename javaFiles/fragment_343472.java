import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class FxMain extends Application {

    private static final int COLS = 5, ROWS = 5;
    private int clickCounter = 0;
    private GridPane grid;
    private Button first, second;

    @Override
    public void start(Stage primaryStage){

        VBox root = new VBox(10);
        root.setPadding(new Insets(10));
        root.getChildren().addAll(makeGrid(), new Text("Click 2 buttons to swap them"));
        primaryStage.setScene(new Scene(root));
        primaryStage.sizeToScene();
        primaryStage.show();
    }

    private Pane makeGrid() {

        grid = new GridPane();
        for(int rowIndex = 0; rowIndex < ROWS ; rowIndex++) {
            //an array to hold buttons of one row 
            Node[] nodes = new Node[COLS];
            for(int colIndex = 0; colIndex < COLS ; colIndex++) {
                Button node= new Button(rowIndex+""+colIndex);
                node.setOnAction(e->buttonCliked(e.getSource())); //add action listener 
                node.prefHeight(100); node.prefWidth(100);
                nodes[colIndex]= node;
            }
            grid.addRow(rowIndex, nodes);
        }
        return grid;
    }

    private void buttonCliked(Object source) {

        if(!(source instanceof Button)) return;
        Button button  = (Button)source;

        if(clickCounter == 0){
            first = button;
        }else{
            second = button;
            swap();
        }

        System.out.println(clickCounter + " " + ((Button)source).getText()    );
        clickCounter=  ++clickCounter %2 ;  // changes values between 0 1
    }

    private void swap() {
        int firstRow = GridPane.getRowIndex(first);
        int firstCol = GridPane.getColumnIndex(first);
        int secondRow = GridPane.getRowIndex(second);
        int secondCol = GridPane.getColumnIndex(second);
        grid.getChildren().removeAll(first, second);
        grid.add(first, secondCol, secondRow);
        grid.add(second, firstCol, firstRow);
    }

    public static void main(final String[] args) {
        launch(args);
    }
}