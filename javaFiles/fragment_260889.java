import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class DialogClosure extends Application{

    @Override
    public void start(Stage stage) throws Exception {
        Button openDialog = new Button("Open Dialog");
        openDialog.setOnAction(event -> {
            Dialog dialog = new Dialog();
            dialog.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
            Node closeButton = dialog.getDialogPane().lookupButton(ButtonType.CLOSE);
            closeButton.managedProperty().bind(closeButton.visibleProperty());
            closeButton.setVisible(false);
            dialog.showAndWait();
        });

        stage.setScene(new Scene(openDialog));
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}