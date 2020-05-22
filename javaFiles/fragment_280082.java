import java.util.regex.Pattern;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.ListChangeListener.Change;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class CountdownTable extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        TableView<Item> table = new TableView<>();
        TableColumn<Item, Integer> secondsCol = new TableColumn<>("Seconds");
        table.getColumns().add(secondsCol);

        secondsCol.setCellValueFactory(cellData -> cellData.getValue().secondsProperty().asObject());

        table.getItems().addListener((Change<? extends Item> c) -> {
            while (c.next()) {
                if (c.wasAdded()) {
                    for (Item item : c.getAddedSubList()) {
                        int startValue = item.getSeconds() ;
                        Timeline countdown = new Timeline(new KeyFrame(Duration.seconds(1), e -> 
                            item.setSeconds(item.getSeconds() - 1)
                        ));
                        countdown.setCycleCount(startValue);
                        countdown.play();
                    }
                }
            }
        });

        TextField textField = new TextField();
        textField.setPromptText("Type a time in seconds and press enter");
        Pattern integerPattern = Pattern.compile("\\d*");
        TextFormatter<Integer> formatter = new TextFormatter<Integer>( (TextFormatter.Change c) -> {
            String newText = c.getControlNewText();
            if (integerPattern.matcher(newText).matches()) {
                return c ;
            } else {
                return null ;
            }
        });
        textField.setTextFormatter(formatter);

        textField.setOnAction(e -> {
            if (! textField.getText().isEmpty())
            table.getItems().add(new Item(Integer.parseInt(textField.getText())));
            textField.clear();
        });

        BorderPane root = new BorderPane(table, null, null, textField, null);
        primaryStage.setScene(new Scene(root, 600, 600));
        primaryStage.show();
    }

    public static class Item {

        private final IntegerProperty seconds = new SimpleIntegerProperty() ;

        public Item(int seconds) {
            setSeconds(seconds);
        }

        public IntegerProperty secondsProperty() {
            return seconds ;
        }

        public final int getSeconds() {
            return secondsProperty().get();
        }

        public final void setSeconds(int seconds) {
            secondsProperty().set(seconds);
        }
    }

    public static void main(String[] args) { launch(args); }
}