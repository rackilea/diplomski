import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener.Change;
import javafx.collections.ObservableList;
import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class FlowPaneWrappedNodes extends Application {


    @Override
    public void start(Stage primaryStage) {
        FlowPane flow = new FlowPane();

        ListView<Node> wrappedNodeView = new ListView<>();

        ChangeListener<Bounds> boundsListener = (obs, oldBounds, newBounds) -> 
            wrappedNodeView.getItems().setAll(findWrapped(flow));

        flow.getChildren().addListener((Change<? extends Node> c) -> {
            while (c.next()) {
                if (c.wasAdded()) {
                    c.getAddedSubList().forEach(node -> node.boundsInParentProperty().addListener(boundsListener));
                }
                if (c.wasRemoved()) {
                    c.getRemoved().forEach(node -> node.boundsInParentProperty().removeListener(boundsListener));
                }
            }
            wrappedNodeView.getItems().setAll(findWrapped(flow));           
        });

        wrappedNodeView.setCellFactory(lv -> new ListCell<Node>() {
            @Override
            public void updateItem(Node item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setText("");
                } else {
                    setText(item.getId());
                }
            }
        });

        Button button = new Button("Add pane");
        button.setOnAction(e ->
                flow.getChildren().add(createPane(flow.getChildren().size()+1)));

        BorderPane root = new BorderPane(flow, null, wrappedNodeView, button, null);
        Scene scene = new Scene(root, 600, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private ObservableList<Node> findWrapped(FlowPane flow) {
        ObservableList<Node> wrapped = FXCollections.observableArrayList();
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