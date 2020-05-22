import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.SplitPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PerformActionOnNodeTypes extends Application {

    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox(5, 
                new Label("Label 1"),
                new HBox(5, new Label("Label 2"), new Button("Button 1")),
                new HBox(5, new TextField("Some text"), new ComboBox<String>()),
                new TabPane(new Tab("Tab 1", new VBox(new Label("Label in tab 1"))),
                        new Tab("Tab 2", new StackPane(new Button("Button in tab 2")))));

        Button button = new Button("Show labeled's texts");
        button.setOnAction(e -> {
            List<Node> allSimpleNodes = new ArrayList<>();
            findAllSimpleNodes(allSimpleNodes, root);
            doAction(allSimpleNodes, Labeled.class, (Labeled l) -> System.out.println(l.getText()));
        });

        root.setAlignment(Pos.CENTER);
        BorderPane.setAlignment(button, Pos.CENTER);
        Scene scene = new Scene(new BorderPane(root, null, null, button, null), 600, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void findAllSimpleNodes(List<Node> allSimpleNodes, Node n) {
        List<Node> children = ChildRetrievalMapping.DEFAULT_INSTANCE.firstMatchingList(n);
        allSimpleNodes.addAll(children);
        for (Node child : children) {
            findAllSimpleNodes(allSimpleNodes, child);
        }
    }

    private <T> void doAction(Collection<Node> nodes, Class<T> type, Consumer<T> action) {
        nodes.stream()
            .filter(type::isInstance)
            .map(type::cast)
            .forEach(action);
    }

    public static class ChildRetrievalMapping {

        public static final ChildRetrievalMapping DEFAULT_INSTANCE = new ChildRetrievalMapping() ;

        static {
            // note the order of insertion is important: start with the more specific type

            DEFAULT_INSTANCE.put(TabPane.class, tabPane -> 
                    tabPane.getTabs().stream().map(Tab::getContent).collect(Collectors.toList()));
            DEFAULT_INSTANCE.put(SplitPane.class, SplitPane::getItems);
            // others...

            // default behavior for "simple" controls, just return empty list:
            DEFAULT_INSTANCE.put(Control.class, c -> Collections.emptyList());

            // default behavior for non-control parents, return getChildrenUnmodifiable:
            DEFAULT_INSTANCE.put(Parent.class, Parent::getChildrenUnmodifiable);


            // and for plain old node, just return empty list:
            DEFAULT_INSTANCE.put(Node.class, n -> Collections.emptyList());
        }

        private final Map<Class<?>, Function<? ,List<Node>>> map = new LinkedHashMap<>();

        public <N extends Node> void put(Class<N> nodeType, Function<N, List<Node>> childRetrieval) {
            map.put(nodeType, childRetrieval);
        }

        @SuppressWarnings("unchecked")
        public <N extends Node> Function<N, List<Node>> getChildRetrieval(Class<N> nodeType) {
            return (Function<N, List<Node>>) map.get(nodeType);
        }

        @SuppressWarnings("unchecked")
        public List<Node> firstMatchingList(Node n) {
            for (Class<?> type : map.keySet()) {
                if (type.isInstance(n)) {
                    return getChildRetrieval((Class<Node>) type).apply(n);
                }
            }
            return Collections.emptyList();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}