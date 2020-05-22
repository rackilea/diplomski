import java.util.Random;
import java.util.stream.IntStream;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.StringConverter;

public class PageNumberCombo extends Application {

    private static final Random RNG = new Random();

    @Override
    public void start(Stage primaryStage) {
        ComboBox<Integer> combo = new ComboBox<>();

        combo.setEditable(true);
        combo.setConverter(new StringConverter<Integer>() {

            @Override
            public String toString(Integer object) {
                return object + " / " + combo.getItems().size();
            }

            @Override
            public Integer fromString(String string) {
                int index = string.indexOf('/');
                if (index < 0) {
                     index = string.length();
                }
                String text = string.substring(0, index).trim();
                try {
                    return Integer.parseInt(text);
                } catch (Exception exc) {
                    return 0 ;
                }
            }

        });

        combo.setCellFactory(lv -> new ListCell<Integer>() {
            @Override
            public void updateItem(Integer item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setText(null) ;
                } else {
                    setText(item.toString());
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