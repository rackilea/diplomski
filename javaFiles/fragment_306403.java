import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.*;

@SuppressWarnings("serial")
public class SwingMenuDemo2 extends JPanel {
    private static final String[] MENU_TEXTS = {"Menu 1", "Menu 2", "Menu 3"};
    private static final int PREF_W = 400;
    private static final int PREF_H = PREF_W;

    public SwingMenuDemo2() {
        JPanel menuPanel = new JPanel(new GridLayout(1, 0));
        for (String menuText : MENU_TEXTS) {
            menuPanel.add(new JButton(menuText));
        }

        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEADING, 0, 0));
        topPanel.add(menuPanel);

        setLayout(new BorderLayout());
        add(topPanel, BorderLayout.PAGE_START);
    }

    @Override
    public Dimension getPreferredSize() {
        if (isPreferredSizeSet()) {
            return super.getPreferredSize();
        }
        return new Dimension(PREF_W, PREF_H);
    }

    private static void createAndShowGui() {
        SwingMenuDemo2 mainPanel = new SwingMenuDemo2();

        JFrame frame = new JFrame("Swing Menu Demo 2");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}