import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.CheckBoxTreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.CheckBoxTreeCell;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class MovingCheckedTreeItems extends Application {

    @Override
    public void start(Stage primaryStage) {
        CheckBoxTreeItem<String> uncheckedTreeRoot = new CheckBoxTreeItem<>("Unchecked tree");
        uncheckedTreeRoot.setExpanded(true);
        TreeView<String> uncheckedTree = new TreeView<>(uncheckedTreeRoot);
        uncheckedTree.setCellFactory(CheckBoxTreeCell.forTreeView());

        CheckBoxTreeItem<String> checkedTreeRoot = new CheckBoxTreeItem<>("Checked tree");
        checkedTreeRoot.setExpanded(true);
        TreeView<String> checkedTree = new TreeView<>(checkedTreeRoot);
        checkedTree.setCellFactory(CheckBoxTreeCell.forTreeView());

        for (int i=0; i<20; i++) {
            CheckBoxTreeItem<String> item = new CheckBoxTreeItem<>("Item "+(i+1));
            item.selectedProperty().addListener((obs, wasSelected, isNowSelected) -> {
                item.getParent().getChildren().remove(item);
                if (isNowSelected) {
                    // add to checkedTree, will take all sub-nodes with it...
                    checkedTreeRoot.getChildren().add(item);
                } else {
                    // add to uncheckedTree
                    uncheckedTreeRoot.getChildren().add(item);
                }
            });
            uncheckedTreeRoot.getChildren().add(item);
        }

        HBox root = new HBox(5, uncheckedTree, checkedTree);
        Scene scene = new Scene(root, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}