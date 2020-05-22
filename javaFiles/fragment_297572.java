import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.stage.FileChooser;

public class MainController {

    @FXML
    private TabPane tabPane ;

    private StringProperty currentText ;

    public void initialize() throws IOException {
        // load an initial tab:
        newTab();
    }

    @FXML
    private void newTab() throws IOException {
        Tab tab = new Tab("Untitled text");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("textEditor.fxml"));

        tab.setContent(loader.load());

        EditorController controller = loader.getController() ;

        tab.selectedProperty().addListener((obs, wasSelected, isNowSelected) -> {
            if (isNowSelected) {
                currentText = controller.textProperty();
            }
        });

        tabPane.getTabs().add(tab);
        tabPane.getSelectionModel().select(tab);
    }

    @FXML
    private void load() {
        FileChooser chooser = new FileChooser();
        File file = chooser.showOpenDialog(tabPane.getScene().getWindow());
        if (file != null) {
            Path path = file.toPath();
            try {
                currentText.set(String.join("\n", Files.readAllLines(path)));
            } catch (IOException e) {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setContentText("Unable to load file "+path);
                alert.setTitle("Load error");
                alert.showAndWait();
            }
            tabPane.getSelectionModel().getSelectedItem().setText(path.getFileName().toString());
        }
    }
}