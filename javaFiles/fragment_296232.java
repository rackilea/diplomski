package com.company;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        TreeNode treeNode = new DefaultMutableTreeNode("Test");

        JTree tree = new JTree();
        tree.setModel(new DefaultTreeModel(treeNode));
        tree.setCellRenderer(new CustomDefaultTreeCellRenderer());

        JFrame frame = new JFrame();
        frame.setContentPane(tree);
        frame.setSize(320, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    static class CustomDefaultTreeCellRenderer extends DefaultTreeCellRenderer {
        @Override
        public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus) {
            boolean enabled = false; // <-- here is your logic for enable/disable cell

            sel = enabled;
            hasFocus = enabled;

            Component treeCellRendererComponent = super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);
            treeCellRendererComponent.setEnabled(enabled);

            return treeCellRendererComponent;
        }
    }
}