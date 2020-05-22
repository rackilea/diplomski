import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));

        primaryStage.focusedProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println("PrimaryStage focused : "+newValue);
        });
        primaryStage.show();

        //create a basic alert
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"This is a test");
        alert.initModality(Modality.WINDOW_MODAL); //will block input to its owner window
        alert.initOwner(primaryStage);

        alert.getButtonTypes().forEach(buttonType -> {
            //add a focus listnener for each buttonType of this alert
            alert.getDialogPane().lookupButton(buttonType).focusedProperty().addListener((observable, oldValue, newValue) -> {
                System.out.println(buttonType.getText()+" focused : "+newValue);
                System.out.println("Alert focused : "+isAlertFocused(alert));

            });
        });
        alert.showAndWait();
    }

    /** Looks all {@link ButtonType} used in the given {@link Alert} and checks if any of them is
     * focused, hence if the {@link Alert} is being focused
     *
     * @param alert the {@link Alert} we want to check the focused status from
     * @return true if the alert is focused, false otherwise
     */
    private boolean isAlertFocused(Alert alert){
        if(alert == null){
            return false;
        }

        final boolean[] focused = {false};
        alert.getButtonTypes().forEach(buttonType -> {
            focused[0] = focused[0] || alert.getDialogPane().lookupButton(buttonType).isFocused();
        });
        return focused[0];
    }


    public static void main(String[] args) {
        launch(args);
    }
}