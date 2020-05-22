import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JavaFXApplication51 extends Application
{

    @Override
    public void start(Stage primaryStage)
    {
        ListView<Fruit> fruitListView = new ListView(FruitList.getFruitList());//Create fruitListView and add its data
        ListView<Vegetables> vegetablesListView = new ListView(VegetableList.getVetetableList());//Create vegetablesListView and add its data

        ChoiceBox<Department> choiceBox = new ChoiceBox(DepartmentList.getDepartmentList());//Create ChoiceBox and add DepartmentList to it
        choiceBox.getSelectionModel().selectedItemProperty().addListener((obs, oldValue, newValue) ->//This is used to observe when the ChoiceBox's value change
        {
            if (newValue != null)//
            {
                Department tempDepartment = (Department) newValue;
                switch (tempDepartment.toString())//Switch on the choosen Department value
                {
                    case "Fruit":
                        fruitListView.setVisible(true);//When Fruit is selected in the ChoiceBox show the fruitList
                        vegetablesListView.setVisible(false);
                        break;
                    case "Vegetables":
                        fruitListView.setVisible(false);
                        vegetablesListView.setVisible(true);//When Vegatables is selected in the ChoiceBox show the vegetablesList
                        break;
                    case "Beverages":
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setHeaderText("Not Implemented Error!");
                        alert.setContentText("You have not implemented this option yet! Do it now!");
                        alert.showAndWait();

                }
            }
        });

        //Inital Setup
        choiceBox.setValue(choiceBox.getItems().get(0));//Set the ChoiceBox's inital value to Fruit

        //Since fruit is the inital value for the ChoicBox, set the fruitListView to visisble and the others to not visible
        fruitListView.setVisible(true);
        vegetablesListView.setVisible(false);
        //End Initial Setup

        StackPane stackPane = new StackPane(fruitListView, vegetablesListView);//Add both ListViews to the StackPane
        VBox vbox = new VBox(stackPane, choiceBox);//Add ListViews and ChoiceBox to VBox
        Scene scene = new Scene(vbox, 300, 250);//Add VBox to root

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        launch(args);
    }
}