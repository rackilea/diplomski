import javafx.application.Application;
import javafx.event.Event;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

public class IdleTest extends Application {

    @Override
    public void start(Stage primaryStage) {

        StackPane root = new StackPane();

        Parent mainUI = buildMainUI();
        Scene scene = new Scene(root, 350, 150);
        Parent startUI = buildStartUI(() -> root.getChildren().setAll(mainUI));
        root.getChildren().add(startUI);

        IdleMonitor idleMonitor = new IdleMonitor(Duration.seconds(30),
                () -> root.getChildren().setAll(startUI), true);
        idleMonitor.register(scene, Event.ANY);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Parent buildStartUI(Runnable start) {
        Button button = new Button("Start");
        button.setOnAction(e -> start.run());
        StackPane root = new StackPane(button);
        return root ;
    }

    private Parent buildMainUI() {
        TabPane tabPane = new TabPane();
        Tab tab1 = new Tab("One");
        Parent tab1Content = buildTabUI("Tab 1");
        Parent tab1StartContent = buildStartUI(() -> tab1.setContent(tab1Content));
        tab1.setContent(tab1StartContent);
        IdleMonitor tab1IdleMonitor = new IdleMonitor(Duration.seconds(5), 
                () -> tab1.setContent(tab1StartContent), true);
        tab1IdleMonitor.register(tab1Content, Event.ANY);

        Tab tab2 = new Tab("Two");
        Parent tab2Content = buildTabUI("Tab 2") ;
        Parent tab2StartContent = buildStartUI(() -> tab2.setContent(tab2Content));
        tab2.setContent(tab2StartContent);
        IdleMonitor tab2IdleMonitor = new IdleMonitor(Duration.seconds(10),
                () -> tab2.setContent(tab2StartContent), true);
        tab2IdleMonitor.register(tab2Content, Event.ANY);

        tabPane.getTabs().addAll(tab1, tab2);
        return tabPane ;
    }

    private Parent buildTabUI(String text) {
        Button button = new Button("Click here");
        button.setOnAction(e -> System.out.println("Click in "+text));
        VBox content = new VBox(10, new Label(text), new TextField(), button);
        content.setAlignment(Pos.CENTER);
        return content ;
    }

    public static void main(String[] args) {
        launch(args);
    }
}