import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class IPAddressEntry extends Application {

    @Override
    public void start(Stage primaryStage) {
        TextField ipAdd1 = new TextField();
        TextField ipAdd2 = new TextField();
        TextField ipAdd3 = new TextField();
        TextField ipAdd4 = new TextField();

        registerListener(ipAdd1, ipAdd2);
        registerListener(ipAdd2, ipAdd3);
        registerListener(ipAdd3, ipAdd4);

        GridPane root = new GridPane();
        root.addRow(0, ipAdd1, ipAdd2, ipAdd3, ipAdd4);

        Scene scene = new Scene(root, 250, 50);
        primaryStage.setScene(scene) ;
        primaryStage.show();
    }

    private void registerListener(TextField tf1, TextField tf2) {
        tf1.textProperty().addListener((obs, oldText, newText) -> {
            if (oldText.length() < 3 && newText.length() >= 3) {
                tf2.requestFocus();
            }
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}