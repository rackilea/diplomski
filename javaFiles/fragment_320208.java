import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 * This class demonstrates custom cell factory so that
 * a given object can be displayed in the combo box button cell and list view
 * in a particular way.  In this demo, the class java.util.AbstractMap.SimpleEntry<K,V> 
 * will be used as the object and only the value will be shown in the combo box. 
 *
 */
@SuppressWarnings("serial")
public class FXComboBoxHashMapDemo extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    private final TextField         fKeyValue        = new TextField();
    private final TextField         fKeyValueDefault = new TextField();
    private final Label             lComboBox        = new Label();
    private final Label             lComboBoxDefault = new Label();
    private final Label             lKeyValue        = new Label();
    private final Label             lKeyValueDefault = new Label();

    private ComboBox<Entry<Integer,String>> fComboBox = new ComboBox<>();
    private ComboBox<Entry<Integer,String>> fComboBoxDefault = new ComboBox<>();

    @SuppressWarnings("unchecked")
    @Override
    public void start(Stage stage) {

        lComboBoxDefault.setText("Combo with default renderer: ");
        fComboBoxDefault.getItems().setAll(populateHashMap());
        fComboBoxDefault.setPrefWidth(100.0);
        fComboBoxDefault.valueProperty().addListener(new ChangeListener() {
            @SuppressWarnings("rawtypes")
            @Override
            public void changed(ObservableValue ov, Object arg1,
                    Object arg2) {
                if (arg2 instanceof SimpleEntry<?,?>) {
                    SimpleEntry<Integer, String> entry = (SimpleEntry<Integer, String>) arg2;
                    fKeyValueDefault.setText("Key: " + entry.getKey() + " Value: " + entry.getValue());
                }
            }    
        });

        lComboBox.setText("Combo with custom renderer: ");
        fComboBox.getItems().setAll(populateHashMap());

        // Customize the cell appearance
        Callback<ListView<Map.Entry<Integer, String>>, ListCell<Map.Entry<Integer, String>>> customCallBack
            = new Callback<ListView<Map.Entry<Integer, String>>, ListCell<Map.Entry<Integer, String>>>() {
             @Override public ListCell<Map.Entry<Integer, String>> call(ListView<Map.Entry<Integer, String>> list) {
                 return new KeyValueFormatCell();
             }
         };
        fComboBox.setButtonCell(customCallBack.call(null));
        fComboBox.setCellFactory(customCallBack);

        fComboBox.valueProperty().addListener(new ChangeListener<Object>() {
            @SuppressWarnings("rawtypes")
            @Override
            public void changed(ObservableValue ov, Object arg1,
                    Object arg2) {
                if (arg2 instanceof SimpleEntry<?,?>) {
                    SimpleEntry<Integer, String> entry = (SimpleEntry<Integer, String>) arg2;
                    fKeyValue.setText("Key: " + entry.getKey() + " Value: " + entry.getValue());
                }
            }    
        });
        fComboBox.setPrefWidth(100.0);

        lKeyValueDefault.setText("Key : Value selected: ");
        lKeyValue.setText("Key : Value selected: ");

        GridPane grid = new GridPane();
        grid.setVgap(4);
        grid.setHgap(10);
        grid.setPadding(new Insets(5, 5, 5, 5));
        grid.add(lComboBoxDefault, 0, 0);
        grid.add(fComboBoxDefault, 1, 0);
        grid.add(lKeyValueDefault, 2, 0);
        grid.add(fKeyValueDefault, 3, 0);
        grid.add(lComboBox, 0, 1);
        grid.add(fComboBox, 1, 1);
        grid.add(lKeyValue, 2, 1);
        grid.add(fKeyValue, 3, 1);

        stage.setTitle("FX ComboBox HashMap Demo");
        Scene scene = new Scene(new Group(), 600,100);
        Group root = (Group)scene.getRoot();
        root.getChildren().add(grid);
        stage.setScene(scene);
        stage.show();
    }

    private List<SimpleEntry<Integer, String>> populateHashMap() {

        List<SimpleEntry<Integer, String>> data = new ArrayList<SimpleEntry<Integer, String>>();
        data.add(new SimpleEntry<Integer, String>(1, "Red"));
        data.add(new SimpleEntry<Integer, String>(2, "Blue"));
        data.add(new SimpleEntry<Integer, String>(3, "Green"));
        return data;
    }

    public class KeyValueFormatCell extends ListCell<Map.Entry<Integer, String>> {

        public KeyValueFormatCell() { }

        @Override protected void updateItem(Map.Entry<Integer, String> item, boolean empty) {
            super.updateItem(item, empty);

            setText(item == null ? "" : item.getValue());

            // For fun, change the text color to match the word
            if (item != null) {
                Paint fillColor = Color.BLACK;
                String color = item.getValue();
                if (color.equals("Red"))
                    fillColor = Color.RED;
                else if (color.equals("Blue"))
                    fillColor = Color.BLUE;
                if (color.equals("Green"))
                    fillColor = Color.GREEN;
                this.setTextFill(fillColor);
            }
        }
    }
}