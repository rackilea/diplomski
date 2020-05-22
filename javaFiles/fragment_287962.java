import java.io.*;
import javafx.application.*;
import javafx.collections.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        VBox pane = new VBox();
        Button importButton = new Button("Import");
        TextField filePath = new TextField("/usr/share/dict/words");
        ObservableList<String> lines = FXCollections.observableArrayList();
        ListView<String> listView = new ListView<>(lines);
        importButton.setOnAction(a -> {
            listView.getItems().clear();
            try {
                BufferedReader in = new BufferedReader
                    (new FileReader(filePath.getText())); 
                String s;
                while ((s = in.readLine()) != null) {
                    listView.getItems().add(s);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        pane.getChildren().addAll(importButton, filePath, listView);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }
}