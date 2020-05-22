import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.plaf.basic.BasicTreeUI;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

@SuppressWarnings("serial")
public class DirectoryExplorer extends JFrame {
    private DirectoryExplorer() {
        super("Directory Explorer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(1, 1));
        createPanel();
        setSize(800,600);
        setVisible(true);
    }

    private void createPanel() {
        JPanel panel = new JPanel(new GridLayout(1, 1));

        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Hello");
        root.add(new DefaultMutableTreeNode("1"));
        root.add(new DefaultMutableTreeNode("2"));
        root.add(new DefaultMutableTreeNode("3"));

        JTree tree = new JTree();

        //UI Stuff//
        TreeHandleUI tUI = new TreeHandleUI(tree);
        tree.setUI(tUI);
        try {
            tUI.setCollapsedIcon(new ImageIcon(new URL("https://i.stack.imgur.com/nKJFv.png")));
            tUI.setExpandedIcon(new ImageIcon(new URL("https://i.stack.imgur.com/NJvcp.png")));
            tUI.setRolloverIcon(new ImageIcon(new URL("https://i.stack.imgur.com/jN6uX.png")));
        } catch(MalformedURLException e) {
            System.out.println("Bad URL / URLs");
        }
        ////////////

        tree.setShowsRootHandles(true);

        panel.add(new JScrollPane(tree));
        getContentPane().add(panel);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> new DirectoryExplorer());
    }

    private class TreeHandleUI extends BasicTreeUI {
        ///Variables
        private JTree t = null;
        private Icon rolloverIcon = null;
        private boolean rolloverEnabled = false;
        private UpdateHandler uH = null;

        private boolean isLeftToRight( Component c ) {
            return c.getComponentOrientation().isLeftToRight();
        }

        public TreeHandleUI(JTree tree) {
            t = tree;
            uH = new UpdateHandler(t);
            t.addMouseMotionListener(uH);
        }

        public void setRolloverIcon(Icon rolloverG) {
            Icon oldValue = rolloverIcon;
            rolloverIcon = rolloverG;
            setRolloverEnabled(true);
            if (rolloverIcon != oldValue) {
                t.repaint();
            }
        }

        private void setRolloverEnabled(boolean handleRolloverEnabled) {
            boolean oldValue = rolloverEnabled;
            rolloverEnabled = handleRolloverEnabled;
            if (handleRolloverEnabled != oldValue) {
                t.repaint();
            }
        }

        @Override
        protected void paintExpandControl(Graphics g,
                                          Rectangle clipBounds, Insets insets,
                                          Rectangle bounds, TreePath path,
                                          int row, boolean isExpanded,
                                          boolean hasBeenExpanded,
                                          boolean isLeaf) {
            Object value = path.getLastPathComponent();

            if (!isLeaf && (!hasBeenExpanded || treeModel.getChildCount(value) > 0)) {
                int middleXOfKnob;
                if (isLeftToRight(t)) {
                    middleXOfKnob = bounds.x - getRightChildIndent() + 1;
                } else {
                    middleXOfKnob = bounds.x + bounds.width + getRightChildIndent() - 1;
                }
                int middleYOfKnob = bounds.y + (bounds.height / 2);

                if (isExpanded) {
                    Icon expandedIcon = getExpandedIcon();
                    if(expandedIcon != null)
                      drawCentered(tree, g, expandedIcon, middleXOfKnob, middleYOfKnob );
                } else if(isLocationInExpandControl(path, uH.getXPos(), uH.getYPos()) && !isExpanded && rolloverEnabled) {
                    if(row == uH.getRow()) {
                        if(rolloverIcon != null)
                            drawCentered(tree, g, rolloverIcon, middleXOfKnob, middleYOfKnob);
                    } else {
                        Icon collapsedIcon = getCollapsedIcon();
                        if(collapsedIcon != null)
                          drawCentered(tree, g, collapsedIcon, middleXOfKnob, middleYOfKnob);
                    }
                } else {
                    Icon collapsedIcon = getCollapsedIcon();
                    if(collapsedIcon != null)
                      drawCentered(tree, g, collapsedIcon, middleXOfKnob, middleYOfKnob);
                }
            }
        }

        private class UpdateHandler extends BasicTreeUI.MouseHandler {
            private JTree t = null;
            private int xPos = 0;
            private int yPos = 0;

            private boolean leftToRight(Component c) {
                return c.getComponentOrientation().isLeftToRight();
            }

            public UpdateHandler(JTree tree) {
                t = tree;
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                xPos = e.getX();
                yPos = e.getY();
                t.repaint();
            }

            public int getXPos() {
                return xPos;
            }

            public int getYPos() {
                return yPos;
            }

            public int getRow() {
                return getRowForPath(t, getClosestPathForLocation(t, xPos, yPos));
            }
        }
    }
}