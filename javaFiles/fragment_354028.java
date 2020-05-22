import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.basic.BasicTabbedPaneUI;

public class TestFrame extends JFrame {

    public TestFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        init();
        pack();
        setVisible(true);
    }

    private void init() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException
                | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        JTabbedPane pane = new JTabbedPane(JTabbedPane.BOTTOM);
        pane.addTab("", new ImageIcon(TestFrame.class.getResource("1111.png")), new JLabel("lbl"));
        pane.addTab("test2", new JLabel("lbl2"));
        pane.setFocusable(false);
        pane.setUI(new BasicTabbedPaneUI() {
            @Override
            protected Insets getTabInsets(int tabPlacement, int tabIndex) {
                return new Insets(0, 0, 0, 0);
            }
        });
        add(pane);
    }


    public static void main(String... strings) {
        new TestFrame();
    }

}