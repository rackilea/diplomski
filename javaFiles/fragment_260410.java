import java.util.Arrays;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableMap;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class BindToObservableMap extends Application {

    private static final String[] keys = {"key1", "key2", "key3"};

    @Override
    public void start(Stage primaryStage) {
        ObservableMap<String, String> map = FXCollections.observableHashMap();
        for (String k : keys) map.put(k, k.replaceAll("key", "value"));

        GridPane grid = new GridPane();
        grid.setHgap(5);
        grid.setVgap(5);
        grid.setPadding(new Insets(10));
        for (int i = 0 ; i < keys.length; i++) {
            grid.add(new Label(keys[i]), 0, i);
            Label boundLabel = new Label();
            boundLabel.textProperty().bind(Bindings.valueAt(map, keys[i]));
            grid.add(boundLabel, 1, i);
        }

        ComboBox<String> keyCombo = new ComboBox<>();
        keyCombo.getItems().setAll(keys);
        TextField valueField = new TextField();
        Button update = new Button("Update");
        EventHandler<ActionEvent> handler = e -> {
            map.put(keyCombo.getValue(), valueField.getText());
            valueField.clear();
            keyCombo.requestFocus();
        };
        valueField.setOnAction(handler);
        update.setOnAction(handler);

        grid.addRow(keys.length, keyCombo, valueField);
        grid.add(update, 0, keys.length + 1);

        Scene scene = new Scene(grid);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}