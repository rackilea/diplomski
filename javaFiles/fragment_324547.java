import java.util.Random;
import java.util.stream.IntStream;

import javafx.application.Application;
import javafx.collections.ListChangeListener.Change;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class PageNumberCombo extends Application {

    private static final Random RNG = new Random();

    @Override
    public void start(Stage primaryStage) {
        ComboBox<Integer> combo = new ComboBox<>();
        combo.setButtonCell(new ListCell<Integer>() {
            {
                itemProperty().addListener((obs, oldValue, newValue) -> update());
                emptyProperty().addListener((obs, oldValue, newValue) -> update());
                combo.getItems().addListener((Change<? extends Integer> c) -> update());
            }

            private void update() {
                if (isEmpty() || getItem() == null) {
                    setText(null);
                } else {
                    setText(String.format("%d / %d", getItem().intValue(), combo.getItems().size()));
                }
            }
        });

        Button reloadButton = new Button("Reload");
        reloadButton.setOnAction(e -> reload(combo));

        reload(combo);

        HBox root = new HBox(10, combo, reloadButton);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(24));
        primaryStage.setScene(new Scene(root, 240, 60));
        primaryStage.show();
    }

    private void reload(ComboBox<Integer> combo) {
        int numPages = RNG.nextInt(10) + 11 ;
        combo.getItems().clear();
        IntStream.rangeClosed(1, numPages).forEach(combo.getItems()::add);
    }

    public static void main(String[] args) {
        launch(args);
    }
}