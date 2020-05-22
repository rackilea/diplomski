import java.util.concurrent.atomic.AtomicInteger;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.IntegerBinding;
import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;


public class CountingTreeViewController {
    @FXML
    private TextField itemTextField ;
    @FXML
    private TreeView<String> tree ;
    @FXML
    private Label countLabel ;

    // binding that contains the total count of all nodes
    // the computeValue() method recursively counts the number of children
    // of each node
    // This binding needs to be invalidated if the list of child nodes of any
    // tree node changes...
    private final IntegerBinding count = new IntegerBinding() {

        @Override
        protected int computeValue() {
            // Note the AtomicInteger here is just used as a mutable wrapper.
            // We don't care about the atomicity since it's only updated from 
            // one thread
            return countNodes(tree.getRoot(), new AtomicInteger());
        }

        private int countNodes(TreeItem<?> node, AtomicInteger count) {
            count.incrementAndGet();
            for (TreeItem<?> child : node.getChildren()) {
                countNodes(child, count);
            }
            return count.intValue();
        }
    };

    // A ListChangeListener that will be associated with any tree node. It does two things:
    // First, it invalidates the count binding above if the number of child nodes changes.
    // Second, it adds the same listener to any new child nodes, and removes it from any nodes
    // that are removed from the tree.
    private final ListChangeListener<TreeItem<String>> childrenChanged 
        = new ListChangeListener<TreeItem<String>>() {

            @Override
            public void onChanged(
                    javafx.collections.ListChangeListener.Change<? extends TreeItem<String>> change) {
                while (change.next()) {
                    if (change.wasAdded() || change.wasRemoved()) {
                        count.invalidate();
                    }
                    if (change.wasAdded()) {
                        for (TreeItem<String> item : change.getAddedSubList()) {
                            item.getChildren().addListener(childrenChanged);
                        }
                    } else if (change.wasRemoved()) {
                        for (TreeItem<String> item : change.getRemoved()) {
                            item.getChildren().removeListener(childrenChanged);
                        }
                    }
                }
            }

    };

    public void initialize(){ 
        tree.getRoot().getChildren().addListener(childrenChanged);
        countLabel.textProperty().bind(Bindings.format("Count: %s", count));
    }


    // add a new child node to the selected node (or the root if nothing's selected)
    @FXML
    private void addItem() {
        TreeItem<String> item = tree.getSelectionModel().getSelectedItem();
        if (item == null) {
            item = tree.getRoot();
        }
        TreeItem<String> newItem = new TreeItem<>(itemTextField.getText());
        newItem.setExpanded(true);
        item.getChildren().add(newItem);
        itemTextField.setText("");
        itemTextField.requestFocus();
    }
}