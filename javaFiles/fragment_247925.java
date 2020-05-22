import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.canvas.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Random;

public class TabbedCanvas extends Application {

    private int tabId = 0;
    private double W = 200, H = 150;

    private Random random = new Random(42);

    @Override
    public void start(Stage stage) {
        TabPane tabPane = new TabPane();

        Button newTabButton = new Button("New Tab");
        newTabButton.setOnAction(
                event -> addTab(tabPane)
        );
        newTabButton.fire();

        ToolBar toolBar = new ToolBar(newTabButton);
        toolBar.setMinHeight(ToolBar.USE_PREF_SIZE);

        VBox layout = new VBox(toolBar, tabPane);
        VBox.setVgrow(tabPane, Priority.ALWAYS);
        stage.setScene(new Scene(layout));
        stage.show();
    }

    private void addTab(TabPane tabPane) {
        Tab tab = new Tab("Tab: " + tabId++);
        tab.setContent(createTabContent());
        tabPane.getTabs().add(tab);
        tabPane.getSelectionModel().select(tab);
    }

    private Node createTabContent() {
        Canvas canvas = new Canvas(W, H);

        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(randomColor());
        gc.fillRect(0, 0, W, H);

        return canvas;
    }

    private Color randomColor() {
        return Color.rgb(
                random.nextInt(256),
                random.nextInt(256),
                random.nextInt(256)
        );
    }

    public static void main(String[] args) {
        launch(args);
    }
}