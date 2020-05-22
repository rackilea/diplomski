import javafx.application.Application;
import javafx.collections.ListChangeListener.Change;
import javafx.geometry.Point2D;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.Window;

public class DetachableTabExample extends Application {

    private int tabCount = 0 ;

    @Override
    public void start(Stage primaryStage) {
        TabPane tabPane = new TabPane();
        Button newTabButton = new Button("New Tab");
        newTabButton.setOnAction(event -> {
            Tab tab = new Tab();
            Label tabLabel = new Label("Tab "+(++tabCount));
            tab.setGraphic(tabLabel);
            tab.setContent(new TextArea());
            tabPane.getTabs().add(tab);

            tabLabel.setOnMouseReleased(me -> {
                Point2D mouseLoc = new Point2D(me.getScreenX(), me.getScreenY());
                Window window = tabPane.getScene().getWindow();
                Rectangle2D windowBounds 
                    = new Rectangle2D(window.getX(), window.getY(),
                                      window.getWidth(), window.getHeight());
                if (! windowBounds.contains(mouseLoc)) {
                    tabPane.getTabs().remove(tab);
                    Stage newStage = new Stage();
                    TabPane newTabPane = new TabPane();
                    newTabPane.getTabs().add(tab);
                    Scene scene = new Scene(new BorderPane(newTabPane));
                    newStage.setScene(scene);
                    newStage.setX(me.getScreenX());
                    newStage.setY(me.getScreenY());
                    newStage.setWidth(window.getWidth());
                    newStage.setHeight(window.getHeight());
                    newStage.show();
                }
            });

        });


        BorderPane root = new BorderPane(tabPane, newTabButton, null, null, null);
        Scene scene = new Scene(root, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}