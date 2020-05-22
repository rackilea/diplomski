import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ComboBoxListenerExample extends Application {

    // This is our ObservableList that will hold our ComboBox items
    private ObservableList<String> items = FXCollections.observableArrayList();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        // Simple interface
        VBox root = new VBox(5);
        root.setPadding(new Insets(10));
        root.setAlignment(Pos.CENTER);

        // Simple ComboBox
        ComboBox<String> comboBox = new ComboBox<>();

        // Let's "permanently" set our ComboBox items to the "items" ObservableList. This causes the
        // ComboBox to "observe" the list for changes
        comboBox.setItems(items);

        // Create a button that will reload data from our "database"
        Button button = new Button("Refresh Data");

        // The items.setAll()` method replaces all items in the list with our new list of items
        button.setOnAction(event -> items.setAll(reloadDatabase()));

        root.getChildren().addAll(comboBox, button);

        // Show the Stage
        primaryStage.setWidth(300);
        primaryStage.setHeight(300);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    // Sample method to simulate reloading the database information
    private List<String> reloadDatabase() {

        List<String> items = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            items.add(getRandomWord());
        }
        return items;

    }

    // Just a helper method specific for this example; it simply returns a random word. 
    // This is used to simulate loading new data from the database
    private String getRandomWord() {

        List<String> words = Arrays.asList("One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Red", "Blue", "Green", "Yellow", "Left", "Right", "Top", "Bottom");
        Random random = new Random();
        return words.get(random.nextInt(words.size()));
    }
}