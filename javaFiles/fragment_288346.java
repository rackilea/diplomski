import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class DualingSplitPanes {

    private JComponent ui = null;

    DualingSplitPanes() {
        initUI();
    }

    protected final void addPanelsToUi(JPanel p1, JPanel p2, JPanel p3) {
        JSplitPane sp1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, p1, p2);
        JSplitPane sp2 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, sp1, p3);
        sp2.setResizeWeight(1);

        ui.add(sp2);
    }

    public void initUI() {
        if (ui!=null) return;

        ui = new JPanel(new BorderLayout(4,4));
        ui.setBorder(new EmptyBorder(4,4,4,4));

        JPanel treeContainer = new JPanel(new GridLayout());
        JTree tree = new JTree();
        tree.setVisibleRowCount(5);
        for (int i=tree.getVisibleRowCount()-1; i>-1; i--) {
            tree.expandRow(i);
        }
        treeContainer.add(new JScrollPane(tree));

        JPanel workSpaceContainer = new JPanel(new GridLayout());
        workSpaceContainer.add(new JTextArea(5, 10));

        JPanel searchContainer = new JPanel(new BorderLayout(4, 4));
        searchContainer.add(new JScrollPane(new JTextArea(5, 10)));

        addPanelsToUi(treeContainer, workSpaceContainer, searchContainer);
    }

    public JComponent getUI() {
        return ui;
    }

    public static void main(String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (Exception useDefault) {
                }
                DualingSplitPanes o = new DualingSplitPanes();

                JFrame f = new JFrame(o.getClass().getSimpleName());
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                f.setLocationByPlatform(true);

                f.setContentPane(o.getUI());
                f.pack();
                f.setMinimumSize(f.getSize());

                f.setVisible(true);
            }
        };
        SwingUtilities.invokeLater(r);
    }
}