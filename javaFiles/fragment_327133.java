import javafx.application.Application;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;




public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            BorderPane root = new BorderPane();

            TreeView<String> treeView = new TreeView<>();
            TreeItem<String> treeRoot = new TreeItem<>("Root");
            for (int i=1; i<=5; i++) {
                TreeItem<String> child = new TreeItem<>("Item "+i);
                child.getChildren().addAll(new TreeItem<>("Item "+i+"A"), new TreeItem<>("Item "+i+"B"));
                treeRoot.getChildren().add(child);
            }
            treeView.setRoot(treeRoot);

            root.setCenter(treeView);

            ObjectProperty<TreeCell<String>> selectedCell = new SimpleObjectProperty<>();
            treeView.setCellFactory(tree -> {
                TreeCell<String> cell = new TreeCell<>();
                cell.textProperty().bind(cell.itemProperty());
                ChangeListener<TreeItem<String>> listener = (obs, oldItem, newItem) -> {
                    TreeItem<String> selectedItem = treeView.getSelectionModel().getSelectedItem();
                    if (selectedItem == null) {
                        selectedCell.set(null);
                    } else {
                        if (selectedItem == cell.getTreeItem()) {
                            selectedCell.set(cell);
                        }
                    }
                };
                cell.treeItemProperty().addListener(listener);
                treeView.getSelectionModel().selectedItemProperty().addListener(listener);
                return cell ;
            });

            ContextMenu contextMenu = new ContextMenu();
            for (int i=1; i<=3; i++) {
                String text = "Choice "+i;
                MenuItem menuItem = new MenuItem(text);
                menuItem.setOnAction(event -> System.out.println(text));
                contextMenu.getItems().add(menuItem);
            }

            treeView.setOnKeyReleased(event -> {
                if (event.getCode() == KeyCode.Z) {
                    if (selectedCell.get() != null) {
                        Node anchor = selectedCell.get();
                                            // figure center of cell in screen coords:
                        Bounds anchorBounds = anchor.getBoundsInParent();
                        double x = anchorBounds.getMinX() + anchorBounds.getWidth() / 2 ;
                        double y = anchorBounds.getMinY() + anchorBounds.getHeight() / 2 ;
                        Point2D screenLoc = anchor.getParent().localToScreen(x, y);
                        contextMenu.show(selectedCell.get(), screenLoc.getX(), screenLoc.getY());
                    }
                }

            });

            Scene scene = new Scene(root,400,400);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}