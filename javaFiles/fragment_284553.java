import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Capstone extends Application
{

    private boolean nuts = false;
    private boolean cherries = false;

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage stage)
    {
        stage.setTitle("Ice Cream - Swejkoski");
        Scene scene = new Scene(new Group(), 750, 125);
        scene.setFill(Color.GHOSTWHITE);

        ToggleGroup group = new ToggleGroup();
        final RadioButton rbChocolate = new RadioButton("Chocolate");
        rbChocolate.setToggleGroup(group);
        rbChocolate.setSelected(true);
        final RadioButton rbVanilla = new RadioButton("Vanilla");
        rbVanilla.setToggleGroup(group);
        final RadioButton rbStrawberry = new RadioButton("Strawberry");
        rbStrawberry.setToggleGroup(group);

        TitledPane gridTitlePaneFlavors = new TitledPane();
        GridPane gridFlavors = new GridPane();
        gridFlavors.setVgap(10);
        gridFlavors.setHgap(4);
        gridFlavors.setPadding(new Insets(1, 1, 1, 1));
        gridFlavors.add(rbChocolate, 0, 0);
        gridFlavors.add(rbVanilla, 1, 0);
        gridFlavors.add(rbStrawberry, 2, 0);
        gridTitlePaneFlavors.setText("Flavors");
        gridTitlePaneFlavors.setContent(gridFlavors);

        final CheckBox checkboxNuts = new CheckBox("Nuts");
        checkboxNuts.selectedProperty().addListener((obs, oldValue, newValue) -> {
            nuts = newValue;
        });


        final CheckBox checkboxCherries = new CheckBox("Cherries");
        checkboxCherries.selectedProperty().addListener((obs, oldValue, newValue) -> {
            cherries = newValue;
        });

        TitledPane gridTitlePaneToppings = new TitledPane();
        GridPane gridToppings = new GridPane();
        gridToppings.setVgap(10);
        gridToppings.setHgap(4);
        gridToppings.setPadding(new Insets(1, 1, 1, 1));
        gridToppings.add(checkboxNuts, 0, 0);
        gridToppings.add(checkboxCherries, 1, 0);
        gridTitlePaneToppings.setText("Toppings");
        gridTitlePaneToppings.setContent(gridToppings);

        final Button buttonCalculate = new Button("Calculate Cost");
        buttonCalculate.setOnAction((event) -> {
            showCalculations();
            System.out.println("Button Action");
        });
        final Button buttonSave = new Button("Save");
        final Button buttonRestore = new Button("Restore");

        TitledPane gridTitlePaneOrder = new TitledPane();
        GridPane gridOrder = new GridPane();
        gridOrder.setVgap(10);
        gridOrder.setHgap(4);
        gridOrder.setPadding(new Insets(1, 1, 1, 1));
        gridOrder.add(buttonCalculate, 0, 0);
        gridOrder.add(buttonSave, 1, 0);
        gridOrder.add(buttonRestore, 2, 0);
        gridTitlePaneOrder.setText("Order");
        gridTitlePaneOrder.setContent(gridOrder);

        HBox hbox = new HBox(10);
        hbox.setPadding(new Insets(20, 0, 0, 20));
        hbox.getChildren().add(gridTitlePaneFlavors);
        hbox.getChildren().add(gridTitlePaneToppings);
        hbox.getChildren().add(gridTitlePaneOrder);

        Group root = (Group) scene.getRoot();
        root.getChildren().add(hbox);
        stage.setScene(scene);
        stage.show();
    }

    public void showCalculations()
    {
        final double salesTax = 0.06;
        final double flavorPrice = 2.25;
        final double nutsPrice = 0.5;
        final double cherriesPrice = 0.5;
        double addonsPrice = 0;

        if (nuts == true) {
            addonsPrice += nutsPrice;
        }
        else if (nuts == false) {
            addonsPrice += 0;
        }
        if (cherries == true) {
            addonsPrice += cherriesPrice;
        }
        else if (cherries == false) {
            addonsPrice += 0;
        }
        double mainTotal = flavorPrice + addonsPrice + ((flavorPrice + addonsPrice) * salesTax);
        double order = flavorPrice + addonsPrice;
        double tax = (flavorPrice + addonsPrice) * salesTax;
        double total = mainTotal;

        Stage calculationStage = new Stage();
        calculationStage.setTitle("Ice Cream Calculations");
        Scene calculationScene = new Scene(new Group(), 400, 400);
        calculationScene.setFill(Color.GHOSTWHITE);

        final Label labelMainTotal = new Label("Total: $" + mainTotal);
        final Label labelOrder = new Label("Order: $" + order);
        final Label labelTax = new Label("Tax: $" + tax);
        final Label labelTotal = new Label("Total: $" + total);

        GridPane gridCalculation = new GridPane();
        gridCalculation.setVgap(10);
        gridCalculation.setHgap(4);
        gridCalculation.add(labelMainTotal, 0, 0);
        gridCalculation.add(labelOrder, 0, 2);
        gridCalculation.add(labelTax, 0, 3);
        gridCalculation.add(labelTotal, 0, 4);

        HBox calculationhbox = new HBox(10);
        calculationhbox.setPadding(new Insets(20, 0, 0, 20));
        calculationhbox.getChildren().setAll(gridCalculation);

        Group calculationRoot = (Group) calculationScene.getRoot();
        calculationRoot.getChildren().add(calculationhbox);
        calculationStage.setScene(calculationScene);
        calculationStage.show();
    }
}