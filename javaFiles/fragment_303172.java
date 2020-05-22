import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultTreeSelectionModel;
import javax.swing.tree.RowMapper;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

public class TestTreeSelection {

    private class MyTreeSelectionModel implements TreeSelectionModel {

        TreeSelectionModel selectionModel = new DefaultTreeSelectionModel();

        private boolean canPathBeAdded(TreePath treePath) {
            return treePath.getPathCount() > 2;
        }

        private TreePath[] getFilteredPaths(TreePath[] paths) {
            List<TreePath> returnedPaths = new ArrayList<TreePath>(paths.length);
            for (TreePath treePath : paths) {
                if (canPathBeAdded(treePath)) {
                    returnedPaths.add(treePath);
                }
            }
            return returnedPaths.toArray(new TreePath[returnedPaths.size()]);
        }

        @Override
        public void setSelectionMode(int mode) {
            selectionModel.setSelectionMode(mode);
        }

        @Override
        public int getSelectionMode() {
            return selectionModel.getSelectionMode();
        }

        @Override
        public void setSelectionPath(TreePath path) {
            if (canPathBeAdded(path)) {
                selectionModel.setSelectionPath(path);
            }
        }

        @Override
        public void setSelectionPaths(TreePath[] paths) {
            paths = getFilteredPaths(paths);
            selectionModel.setSelectionPaths(paths);
        }

        @Override
        public void addSelectionPath(TreePath path) {
            if (canPathBeAdded(path)) {
                selectionModel.addSelectionPath(path);
            }
        }

        @Override
        public void addSelectionPaths(TreePath[] paths) {
            paths = getFilteredPaths(paths);
            selectionModel.addSelectionPaths(paths);
        }

        @Override
        public void removeSelectionPath(TreePath path) {
            selectionModel.removeSelectionPath(path);
        }

        @Override
        public void removeSelectionPaths(TreePath[] paths) {
            selectionModel.removeSelectionPaths(paths);
        }

        @Override
        public TreePath getSelectionPath() {
            return selectionModel.getSelectionPath();
        }

        @Override
        public TreePath[] getSelectionPaths() {
            return selectionModel.getSelectionPaths();
        }

        @Override
        public int getSelectionCount() {
            return selectionModel.getSelectionCount();
        }

        @Override
        public boolean isPathSelected(TreePath path) {
            return selectionModel.isPathSelected(path);
        }

        @Override
        public boolean isSelectionEmpty() {
            return selectionModel.isSelectionEmpty();
        }

        @Override
        public void clearSelection() {
            selectionModel.clearSelection();
        }

        @Override
        public void setRowMapper(RowMapper newMapper) {
            selectionModel.setRowMapper(newMapper);
        }

        @Override
        public RowMapper getRowMapper() {
            return selectionModel.getRowMapper();
        }

        @Override
        public int[] getSelectionRows() {
            return selectionModel.getSelectionRows();
        }

        @Override
        public int getMinSelectionRow() {
            return selectionModel.getMinSelectionRow();
        }

        @Override
        public int getMaxSelectionRow() {
            return selectionModel.getMaxSelectionRow();
        }

        @Override
        public boolean isRowSelected(int row) {
            return selectionModel.isRowSelected(row);
        }

        @Override
        public void resetRowSelection() {
            selectionModel.resetRowSelection();
        }

        @Override
        public int getLeadSelectionRow() {
            return selectionModel.getLeadSelectionRow();
        }

        @Override
        public TreePath getLeadSelectionPath() {
            return selectionModel.getLeadSelectionPath();
        }

        @Override
        public void addPropertyChangeListener(PropertyChangeListener listener) {
            selectionModel.addPropertyChangeListener(listener);
        }

        @Override
        public void removePropertyChangeListener(PropertyChangeListener listener) {
            selectionModel.removePropertyChangeListener(listener);
        }

        @Override
        public void addTreeSelectionListener(TreeSelectionListener x) {
            selectionModel.addTreeSelectionListener(x);
        }

        @Override
        public void removeTreeSelectionListener(TreeSelectionListener x) {
            selectionModel.removeTreeSelectionListener(x);
        }

    }

    protected void initUI() {
        final DefaultMutableTreeNode root = new DefaultMutableTreeNode("Root");
        fillTree(root, 5, "Some tree label");
        final DefaultTreeModel model = new DefaultTreeModel(root);
        JTree tree = new JTree(model);
        tree.setSelectionModel(new MyTreeSelectionModel());
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(new JScrollPane(tree));
        f.setSize(400, 600);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    private void fillTree(DefaultMutableTreeNode parent, int level, String label) {
        for (int i = 0; i < 5; i++) {
            DefaultMutableTreeNode node = new DefaultMutableTreeNode(label + " " + i);
            parent.add(node);
            if (level > 0) {
                fillTree(node, level - 1, label);
            }
        }

    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new TestTreeSelection().initUI();
            }
        });
    }

}