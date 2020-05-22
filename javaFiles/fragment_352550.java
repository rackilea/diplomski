import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class DynamicTable extends Application{

    @Override
    public void start(Stage ps) throws Exception {

        // Create a Tab A, create a container and add it 
        Tab tabA = new Tab("Tab A");
        StackPane containerA = new StackPane();

        // note that the colors are for example
        containerA.setBackground(new Background(
                new BackgroundFill(Color.MAROON,null,null)));
        // Create a comboBox, set its attributes and add it to container
        ComboBox<Integer> comboBox = new ComboBox<Integer>();
        comboBox.getItems().addAll(1,2,3,4,5,6,7,8,9,10);
        comboBox.setValue(1);
        comboBox.setEditable(false);
        containerA.getChildren().add(comboBox);

        //add the container to the tabA
        tabA.setContent(containerA);

        // Create Tab B, create a container and add it 
        Tab tabB = new Tab("Tab B");
        StackPane containerB = new StackPane();

        containerB.setBackground(new Background(
                        new BackgroundFill(Color.DARKMAGENTA,null,null)));
        tabB.setContent(containerB);
        // create TabPane and add the Tabs to it
        // all other values need manipulation (i.e. up to your preference)
        TabPane tabPane = new TabPane();
         tabPane.getTabs().addAll(tabA, tabB);
        //set size and other attributes (if any), for example 
        tabPane.setMinWidth(500);
        tabPane.setMinHeight(500);

         // add listener to tabPane
         tabPane.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Tab>(){
              @Override
              public void changed(ObservableValue<? extends Tab> observable, Tab oldTab, Tab newTab){
                   if(newTab == tabB) { // when tabB is selected
                       if(containerB.getChildren().size()>0){ // if already contains a table
                           containerB.getChildren().remove(0); // remove it
                       }
                       containerB.getChildren().add(table(comboBox.getValue())); // create the table and add it   
                 }
            }   
        });

        // simple root to test 
        Pane root = new Pane();
        root.getChildren().add(tabPane);

        Scene scene = new Scene(root, 500,500);
        ps.setScene(scene);
        ps.setTitle("Dynamic Table In Tab");
        ps.show();
    }


    // This static method shall create the table dynamically when it's called
    // you can add, change and remove the attributes of the table components
    // the colors and all other decoration(e.g. position) are for example
    public static GridPane table(int rows){
        GridPane table = new GridPane();

        for(int i=0; i<rows; i++){
            TextField textField = new TextField();
            textField.setAlignment(Pos.CENTER);
            CheckBox checkBox = new CheckBox("Check Box");
            checkBox.setTextFill(Color.WHITE);
            checkBox.setAlignment(Pos.CENTER);
            DatePicker datePicker = new DatePicker();

            //add them to the GridPane
            table.add(textField, 0, i); //  (child, columnIndex, rowIndex)
            table.add(checkBox , 1, i);
            table.add(datePicker,2, i);

            // margins are up to your preference
            GridPane.setMargin(textField, new Insets(5));
            GridPane.setMargin(checkBox, new Insets(5));
            GridPane.setMargin(datePicker, new Insets(5));
         }
        table.setAlignment(Pos.CENTER);

        return table;

    }

    public static void main(String[] args) {
        launch();

    }
}