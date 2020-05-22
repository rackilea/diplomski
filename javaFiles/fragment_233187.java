import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import org.jdesktop.swingx.JXMultiSplitPane;
import org.jdesktop.swingx.MultiSplitLayout;
import org.jdesktop.swingx.MultiSplitLayout.Divider;
import org.jdesktop.swingx.MultiSplitLayout.Leaf;
import org.jdesktop.swingx.MultiSplitLayout.Split;

public class TestMultiSplitPane {

    public static final String LEFT = "left";
    public static final String CENTER = "center";
    public static final String RIGHT = "right";

    public static final String TOP = "top";
    public static final String MIDDLE = "middle";
    public static final String BOTTOM = "bottom";

    protected void initUI() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Split horizontal = new Split();
        Split left = getVerticalSplit(LEFT, 0.5, 0.5);
        left.setWeight(0.2);
        Split center = getVerticalSplit(CENTER, 0.8, 0.2);
        center.setWeight(0.6);
        Split right = getVerticalSplit(RIGHT, 0.5, 0.5);
        right.setWeight(0.2);
        horizontal.setChildren(left, new Divider(), center, new Divider(), right);
        MultiSplitLayout layout = new MultiSplitLayout(horizontal);
        JXMultiSplitPane splitPane = new JXMultiSplitPane(layout);
        addButton(LEFT + TOP, splitPane);
        addButton(CENTER + TOP, splitPane);
        addButton(RIGHT + TOP, splitPane);
        addButton(LEFT + BOTTOM, splitPane);
        addButton(CENTER + BOTTOM, splitPane);
        addButton(RIGHT + BOTTOM, splitPane);
        frame.add(splitPane);
        frame.setBounds(50, 50, 1024, 768);
        frame.setVisible(true);
    }

    protected void addButton(final String buttonName, final JXMultiSplitPane splitPane) {
        final JButton button = new JButton(buttonName);
        splitPane.add(buttonName, button);
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                MultiSplitLayout layout = splitPane.getMultiSplitLayout();
                layout.displayNode(buttonName, false);
            }
        });
    }

    public Split getVerticalSplit(String name, double topWeight, double bottomWeight) {
        Split split = new Split();
        split.setRowLayout(false);
        Leaf top = new Leaf(name + TOP);
        top.setWeight(topWeight);
        Leaf bottom = new Leaf(name + BOTTOM);
        bottom.setWeight(bottomWeight);
        split.setChildren(top, new Divider(), bottom);
        return split;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new TestMultiSplitPane().initUI();

            }
        });
    }
}