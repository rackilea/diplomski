import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MnemonicAcceleratedMenu extends Application {
    @Override
    public void start(Stage stage) {
        Menu fileMenu = new Menu("_File");
        MenuItem newFileMenuItem = new MenuItem("_New...");
        newFileMenuItem.setAccelerator(
            KeyCombination.keyCombination("SHORTCUT+N")
        );
        newFileMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Something new, this way comes");
            }
        });
        fileMenu.getItems().add(
                newFileMenuItem
        );

        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().setAll(
                fileMenu
        );

        VBox layout = new VBox(menuBar);
        layout.setPrefSize(200, 100);

        stage.setScene(new Scene(layout));
        stage.show();
    }

   public static void main(String[] args) {
        launch(args);
    }
}