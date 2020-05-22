import javafx.application.Application;
import javafx.beans.property.*;
import javafx.geometry.*;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ResizableKeyboardSample extends Application {
    public static void main(String[] args) throws Exception {
        launch(args);
    }

    String[] chars = {
            "qwertyuiop",
            "asdfghjkl",
            "zxcvbnm"
    };

    public void start(final Stage stage) throws Exception {
        Keyboard keyboard = new Keyboard();

        VBox layout = new VBox(20);
        layout.setPadding(new Insets(10));
        layout.getChildren().setAll(
                createControls(keyboard),
                keyboard
        );

        Scene scene = new Scene(layout, 1000, 400);
        scene.getStylesheets().add(
                getClass().getResource(
                        "keyboard.css"
                ).toExternalForm()
        );

        stage.setScene(scene);
        stage.show();
    }

    private Node createControls(Keyboard keyboard) {
        Slider fontSize = new Slider(8, 40, Font.getDefault().getSize());
        keyboard.fontSizeProperty().bind(fontSize.valueProperty());
        fontSize.setShowTickLabels(true);
        fontSize.setShowTickMarks(true);
        fontSize.setMajorTickUnit(2);
        fontSize.setMinorTickCount(0);

        Label typedData = new Label();
        keyboard.lastKeyTextProperty().addListener((observable, oldText, newText) ->
                typedData.setText(typedData.getText() + newText)
        );

        VBox layout = new VBox(10);
        layout.getChildren().setAll(
                new Label("Keyboard Size"),
                fontSize,
                typedData
        );
        layout.setMinSize(VBox.USE_PREF_SIZE, VBox.USE_PREF_SIZE);

        return layout;
    }

    class Keyboard extends VBox {
        private DoubleProperty fontSize = new SimpleDoubleProperty(Font.getDefault().getSize());

        public double getFontSize() {
            return fontSize.get();
        }

        public DoubleProperty fontSizeProperty() {
            return fontSize;
        }

        public void setFontSize(double fontSize) {
            this.fontSize.set(fontSize);
        }

        private ReadOnlyStringWrapper lastKeyText = new ReadOnlyStringWrapper();

        public String getLastKeyText() {
            return lastKeyText.get();
        }

        public ReadOnlyStringProperty lastKeyTextProperty() {
            return lastKeyText.getReadOnlyProperty();
        }

        public Keyboard() {
            setAlignment(Pos.BOTTOM_CENTER);
            setMinSize(VBox.USE_PREF_SIZE, VBox.USE_PREF_SIZE);
            getStyleClass().add("keyboard");

            onFontSizeChange(fontSize.getValue());
            fontSize.addListener((observable, oldValue, newValue) ->
                onFontSizeChange(newValue)
            );

            for (String row: chars) {
                HBox keyRow = new HBox();
                keyRow.getStyleClass().add("key-row");

                keyRow.setAlignment(Pos.CENTER);
                for (char c: row.toCharArray()) {
                    KeyButton key = new KeyButton(Character.toString(c));
                    keyRow.getChildren().add(key);
                }
                getChildren().add(keyRow);
            }
        }

        private void onFontSizeChange(Number newValue) {
            setStyle("-fx-font-size: " + newValue + "px;");
        }

        class KeyButton extends Button {
            public KeyButton(String text) {
                super(text);
                getStyleClass().add("key");

                setMinSize(Button.USE_PREF_SIZE, Button.USE_PREF_SIZE);
                setMaxSize(Button.USE_PREF_SIZE, Button.USE_PREF_SIZE);

                setOnAction(event -> lastKeyText.set(text));
            }
        }
    }

}