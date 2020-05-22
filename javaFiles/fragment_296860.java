import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javafx.application.Application;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Task;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class LazyTreeCellLoadingExample2 extends Application {

    private static final ExecutorService EXEC = Executors.newCachedThreadPool((Runnable r) -> {
        Thread t = new Thread(r);
        t.setDaemon(true);
        return t ;
    });

    @Override
    public void start(Stage primaryStage) {
        TreeView<Integer> tree = new TreeView<>();
        tree.setRoot(new LazyTreeItem(1));

        tree.setCellFactory(tv -> createTreeCell()) ;

        primaryStage.setScene(new Scene(new BorderPane(tree), 450, 600));
        primaryStage.show();
    }

    private TreeCell<Integer> createTreeCell() {

        ProgressBar progressBar = new ProgressBar();
        TreeCell<Integer> cell = new TreeCell<>();

        ChangeListener<Boolean> loadingChangeListener = 
                (ObservableValue<? extends Boolean> obs, Boolean wasLoading, Boolean isNowLoading) -> {
                   if (isNowLoading) {
                       cell.setGraphic(progressBar);
                   } else {
                       cell.setGraphic(null);
                   }
                };

        cell.treeItemProperty().addListener( 
                (ObservableValue<? extends TreeItem<Integer>> obs, 
                        TreeItem<Integer> oldItem, 
                        TreeItem<Integer> newItem) -> {

                if (oldItem != null) {
                    LazyTreeItem oldLazyTreeItem = (LazyTreeItem) oldItem ;
                    oldLazyTreeItem.loadingProperty().removeListener(loadingChangeListener);
                }

                if (newItem != null) {
                    LazyTreeItem newLazyTreeItem = (LazyTreeItem) newItem ;
                    newLazyTreeItem.loadingProperty().addListener(loadingChangeListener);

                    if (newLazyTreeItem.isLoading()) {
                        cell.setGraphic(progressBar);
                    } else {
                        cell.setGraphic(null);
                    }
                }
        });

        cell.itemProperty().addListener(
                (ObservableValue<? extends Integer> obs, Integer oldItem, Integer newItem) -> {
                   if (newItem == null) {
                       cell.setText(null);
                       cell.setGraphic(null);
                   } else {
                       cell.setText(newItem.toString());
                   }
                });

        return cell ;
    }

    public static class LazyTreeItem extends TreeItem<Integer> {

        private final BooleanProperty loading = new SimpleBooleanProperty(false);

        private boolean leaf = false ;

        public final BooleanProperty loadingProperty() {
            return this.loading;
        }

        public final boolean isLoading() {
            return this.loadingProperty().get();
        }

        public final void setLoading(final boolean loading) {
            this.loadingProperty().set(loading);
        }


        public LazyTreeItem(Integer value) {
            super(value);

            expandedProperty().addListener((ObservableValue<? extends Boolean>obs,  Boolean wasExpanded,  Boolean isNowExpanded) -> {
                if (isNowExpanded) {
                    loadChildrenLazily();
                } else {
                    clearChildren();
                }
            });
        }

        @Override
        public boolean isLeaf() {
            return leaf ;
        }

        private void loadChildrenLazily() {

            setLoading(true);

            int value = getValue();
            Task<List<TreeItem<Integer>>> loadTask = new Task<List<TreeItem<Integer>>>() {

                @Override
                protected List<TreeItem<Integer>> call() throws Exception {
                    List<TreeItem<Integer>> children = new ArrayList<>();
                    for (int i=0; i<10; i++) {
                        children.add(new LazyTreeItem(value * 10 + i));
                    }
                    Thread.sleep(3000);
                    return children ;
                }

            };

            loadTask.setOnSucceeded(event -> {
                List<TreeItem<Integer>> children = loadTask.getValue();
                leaf = children.size() == 0 ;
                getChildren().setAll(children);
                setLoading(false);
            });

            EXEC.submit(loadTask);
        }

        private void clearChildren() {
            getChildren().clear();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}