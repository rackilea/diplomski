import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

@SuppressWarnings("serial")
public class LayoutExample extends JFrame {
    private JTabbedPane tabs;
    private JPanel migPanel;
    private JPanel gridBagPanel;
    private JPanel migPanelCC;
    private JPanel gridBagPanelCC;
    private String[] dummyList  = new String[] {
        "Val 1",
        "Val 2"
    };

    private LayoutExample() {
        super("Layout Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setUpTabs();
        add(tabs);

        setSize(800, 500);
        setVisible(true);
    }

    private void setUpTabs() {
        tabs = new JTabbedPane();

        setUpMig();
        tabs.add(migPanel, "Mig Panel");

        setUpMigCC();
        tabs.add(migPanelCC, "Mig Panel Center Center");

        setUpGridBag();
        tabs.add(gridBagPanel, "Grid Bag Panel");

        setUpGridBagCC();
        tabs.add(gridBagPanelCC, "Grid Bag Panel Center Center");
    }

    private void setUpMig() {
        migPanel = new JPanel(new MigLayout("center, filly"));
        addToMigPanel(migPanel);
    }

    private void setUpMigCC() {
        migPanelCC = new JPanel(new MigLayout("center, center"));
        addToMigPanel(migPanelCC);
    }

    private void addToMigPanel(JPanel mPanel) {
        mPanel.add(new JLabel("Header"), "span, align center");
        mPanel.add(new JTextField("Input"), "split 4");
        mPanel.add(new JComboBox<String>(dummyList));
        mPanel.add(new JLabel("To"), "span");
        mPanel.add(new JComboBox<String>(dummyList), "wrap");
        mPanel.add(new JButton("Convert"), "span, align center");
        mPanel.add(new JTextField("Output"), "span, align center");
    }

    private void setUpGridBag() {
        gridBagPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        gc.weighty = 1;
        addToGridBagPanel(gridBagPanel, gc);
    }

    private void setUpGridBagCC() {
        gridBagPanelCC = new JPanel(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        addToGridBagPanel(gridBagPanelCC, gc);
    }

    private void addToGridBagPanel(JPanel gblPanel, GridBagConstraints gc) {
        gc.gridwidth = 4;
        gblPanel.add(new JLabel("Header"), gc);

        gc.gridy = 1;
        gc.gridwidth = 1;
        gblPanel.add(new JTextField("Input"), gc);

        gc.gridx = 1;
        gblPanel.add(new JComboBox<String>(dummyList), gc);

        gc.gridx = 2;
        gblPanel.add(new JLabel("To"), gc);

        gc.gridx = 3;
        gblPanel.add(new JComboBox<String>(dummyList), gc);

        gc.gridy = 2;
        gc.gridx = 0;
        gc.gridwidth = 4;
        gblPanel.add(new JButton("Convert"), gc);

        gc.gridy = 3;
        gblPanel.add(new JTextField("Output"), gc);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> new LayoutExample());
    }
}