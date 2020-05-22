import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class StoreNumbers extends Application {
    private TextField textField = new TextField();
    private TextArea textArea = new TextArea();
    StoreNumberPane snPane = new StoreNumberPane();
    public List<String> arrayList = new ArrayList<>();

    public void start(Stage primaryStage) {

        Button btSort = new Button("Sort");
        Button btShuffle = new Button("Shuffle");
        Button btReverse = new Button("Reverse");
        HBox hBox = new HBox(10);
        hBox.getChildren().addAll(btSort, btShuffle, btReverse);
        hBox.setAlignment(Pos.CENTER);

        btSort.setOnAction(e -> { snPane.sort(arrayList); refreshData(); });
        btShuffle.setOnAction(e -> { snPane.shuffle(arrayList); refreshData(); });
        btReverse.setOnAction(e -> { snPane.reverse(arrayList); refreshData(); });

        Label label = new Label("Enter a number: ");

        textField.setPromptText("Enter String");
        textArea.setEditable(false);
        FlowPane flowPane = new FlowPane();

        flowPane.getChildren().addAll(label, textField);

        ScrollPane scrollPane = new ScrollPane(textArea);

        BorderPane pane = new BorderPane();
        pane.setCenter(textArea);
        pane.setBottom(hBox);
        pane.setTop(flowPane);

        pane.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                obtainData();
                textField.clear();
            }
        });

        Scene scene = new Scene(pane, 400, 400);
        primaryStage.setTitle("Exercise20_20");
        primaryStage.setScene(scene);
        primaryStage.show();

        snPane.requestFocus();
    }

    public void displayArray() {

    }

    private void obtainData() {
        String userInput = textField.getText();
        if (userInput != null)
            arrayList.add(userInput);
        textArea.setText(String.format("%s", arrayList));
    }

    private void refreshData() {
        textArea.clear();
        textArea.setText(String.format("%s", arrayList));
    }
    public static void main(String[] args) {
        launch(args);
    }

}

class StoreNumberPane extends Pane {

    public void sort(List<String> list) {
        Collections.sort(list);
    }

    public void shuffle(List<String> list) {
        Collections.shuffle(list);
    }

    public void reverse(List<String> list) {
        Collections.reverse(list);
    }

}