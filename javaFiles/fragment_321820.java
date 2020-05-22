import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class FlowPaneWrappedNodes extends Application {


    @Override
    public void start(Stage primaryStage) {
        FlowPane flow = new FlowPane();
        for (int i = 1 ; i <= 15; i++) {
            flow.getChildren().add(createPane(i));
        }
        Button button = new Button("Find wrapped");
        button.setOnAction(e ->
                findWrapped(flow).stream().map(Node::getId).forEach(System.out::println));
        BorderPane root = new BorderPane(flow, null, null, button, null);
        Scene scene = new Scene(root, 600, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private List<Node> findWrapped(FlowPane flow) {
        List<Node> wrapped = new ArrayList<>();
        if (flow.getChildren().size() == 0) {
            return wrapped ;
        }
        double y = flow.getChildren().get(0).getBoundsInParent().getMaxY();
        for (Node child : flow.getChildren()) {
            if (child.getBoundsInParent().getMinY() >= y) {
                wrapped.add(child);
            }
        }
        return wrapped ;
    }

    private Pane createPane(int id) {
        Pane pane = new StackPane();
        pane.setMinSize(50, 50);
        pane.setId("Pane "+id);

        Label label = new Label(Integer.toString(id));
        pane.getChildren().add(label);

        return pane ;
    }

    public static void main(String[] args) {
        launch(args);
    }
}