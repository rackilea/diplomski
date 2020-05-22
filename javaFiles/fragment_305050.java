import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ComboBoxExample extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        GridPane gridPane = new GridPane();
        Button button = new Button("Print items from ComboBox");
        final ComboBox<String> comboBox = new ComboBox<String>();
        //Add some items
        comboBox.getItems().addAll("John","Jane","Laina");

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                //To iterate through ComboBox
                ObservableList<String> items = comboBox.getItems();
                for(String item : items){
                    System.out.println(item.toString());
                }
            }
        });

        gridPane.add(comboBox,0,0);
        gridPane.add(button,0,1);

        primaryStage.setScene(new Scene(gridPane,320,280));
        primaryStage.show();
    }
}