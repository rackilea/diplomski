import javafx.stage.*;
import javafx.application.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class SimpleGUI extends Application {
 public void start(Stage primaryStage) throws Exception {
  GridPane root = new GridPane();
  Scene scene = new Scene(root);

   //Buttons
   Button b1 = new Button("KNAPP 1");
   Button b2 = new Button("KNAPP 2");
   Button b3 = new Button("KNAPP 3");
   Button b4 = new Button("KNAPP 4");
   Button b5 = new Button("KNAPP 5");
   Button b6 = new Button("KNAPP 6");

   root.add(b1, 0, 0);
   root.add(b2, 1, 0);
   root.add(b3, 2, 0);

   root.add(b4, 0, 1);
   root.add(b5, 0, 2);

   // node, columnIndex, rowIndex, columnSpan, rowSpan:
   root.add(b6, 1, 1, 2, 2);

   // allow button to grow:
   b6.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

   primaryStage.setScene(scene);
   primaryStage.show();
 }

 public static void main(String[] args){
  launch(args);
 }
}