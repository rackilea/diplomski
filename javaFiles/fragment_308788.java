import java.awt.*;
import java.awt.event.*;
import java.awt.GridBagLayout;
import javax.swing.*;
import javax.swing.UIManager.LookAndFeelInfo;

public class GUI2 extends JFrame {
    private static LookAndFeel originalLookAndFeel = UIManager.getLookAndFeel();
/*
    private GridBagLayout gridBag = new GridBagLayout();
    private JTabbedPane tabs = new JTabbedPane();
    private JPanel selectionPanel = new JPanel(gridBag);
    private JPanel infoPanel = new JPanel(gridBag);
    private JPanel settingsPanel = new JPanel(gridBag);
*/
    private GridBagLayout gridBag;
    private JTabbedPane tabs;
    private JPanel selectionPanel;
    private JPanel infoPanel;
    private JPanel settingsPanel;

    public GUI2() {
        System.out.println("At start, look and feel is " + UIManager.getLookAndFeel().getName());
        try {
//            setNimbusLookAndFeel();
          UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Look and feel changed to " + UIManager.getLookAndFeel().getName()
                + " before component creation");

        gridBag = new GridBagLayout();
        setLayout(gridBag);
        tabs = new JTabbedPane();
        selectionPanel = new JPanel(gridBag);
        infoPanel = new JPanel(gridBag);
        settingsPanel = new JPanel(gridBag);

        setUpComponents();
        addComponents();
        setWindowProperties();

        Action reset = new AbstractAction()
        {
            public void actionPerformed(ActionEvent ae)
            {
                try {
                    System.out.println("Setting to original, which is " + originalLookAndFeel.getName());
                    UIManager.setLookAndFeel(originalLookAndFeel);
                    System.out.println("Current look and feel is " + UIManager.getLookAndFeel().getName());
                } catch (UnsupportedLookAndFeelException e) {
                    //e.printStackTrace();
                    System.out.println(e.getMessage());
                }

            }
        };

        Timer timer = new Timer(500, reset);
        timer.setRepeats(false);
        timer.start();
    }

    private void setWindowProperties() {
//        setLayout(gridBag);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("fAmos Quester");
//        setResizable(false);
        pack();
        setLocationRelativeTo(null);
    }

    private void setNimbusLookAndFeel() {
        try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                }
            }
        } catch (Exception e) {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e2) {
            }
        }
    }

    public void setUpComponents() {
        tabs.addTab("Quest selection", selectionPanel);
        tabs.addTab("Quest info", infoPanel);
        tabs.addTab("Settings", settingsPanel);

        selectionPanel.setPreferredSize(new Dimension(650, 500));
        infoPanel.setPreferredSize(new Dimension(650, 500));
        settingsPanel.setPreferredSize(new Dimension(650, 500));
    }

    private void addComponents() {
        add(tabs);
    }

    public static void main(String[] args) {
        new GUI2().setVisible(true);
    }
}