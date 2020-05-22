import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.*;

public class MyMain extends JPanel {
    public static final String MENU_PANEL = "MENU";
    public static final String ABOUT_PANEL = "About";
    private CardLayout cardLayout = new CardLayout();

    public MyMain() {
        JPanel aboutPanel = new JPanel(new GridBagLayout());
        JLabel aboutLabel = new JLabel("About");
        aboutLabel.setFont(aboutLabel.getFont().deriveFont(Font.BOLD, 32));
        aboutPanel.add(aboutLabel);

        JPanel buttonPanel = new JPanel(new GridLayout(0, 1, 10, 10));
        buttonPanel.add(createButton(new ExitAction("Exit!", KeyEvent.VK_X)));
        buttonPanel.add(createButton(new OpenBrowserAction("Open Hacked Browser", KeyEvent.VK_O)));
        buttonPanel.add(createButton(new AboutAction("About", KeyEvent.VK_A, this)));        

        JPanel menuPanel = new JPanel(new GridBagLayout());
        int ebGap = 40;
        menuPanel.setBorder(BorderFactory.createEmptyBorder(ebGap, ebGap, ebGap, ebGap));
        menuPanel.add(buttonPanel);

        setLayout(cardLayout);
        add(menuPanel, MENU_PANEL);
        add(aboutPanel, ABOUT_PANEL);
    }

    private JButton createButton(Action action) {
        JButton button = new JButton(action);
        Font btnFont = button.getFont().deriveFont(Font.BOLD, 20);
        button.setFont(btnFont);
        return button;
    }

    private static void createAndShowGui() {
        JFrame frame = new JFrame("My Main Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new MyMain());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }

    public void showPanel(String cardLayoutKey) {
        cardLayout.show(this, cardLayoutKey);
    }
}