import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.geometry.Side;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class ShowTabContextMenu extends Application {

    @Override
    public void start(Stage primaryStage) {
        TabPane tabPane = new TabPane();
        Tab tab = new Tab("Tab");
        tab.setId("myTab");

        tabPane.getTabs().add(tab);

        ContextMenu contextMenu = new ContextMenu();
        contextMenu.getItems().addAll(new MenuItem("Choice 1"), new MenuItem("Choice 2"));
        tab.setContextMenu(contextMenu);

        Scene scene = new Scene(tabPane, 400, 400);
        PauseTransition pause = new PauseTransition(Duration.seconds(2));

        pause.setOnFinished(e -> {
            Node theTab = tabPane.lookup("#myTab");
            contextMenu.show(theTab, Side.RIGHT, 0, 0);
        });

        primaryStage.setScene(scene);
        primaryStage.show();

        pause.play();
    }

    public static void main(String[] args) {
        launch(args);
    }
}