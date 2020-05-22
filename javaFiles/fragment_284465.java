import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.*;
import javax.swing.event.SwingPropertyChangeSupport;

public class Temp2 extends JPanel {
    private CardLayout cardLayout = new CardLayout();
    private GamePanel gamePanel = new GamePanel(this);
    private IntroPanel introPanel = new IntroPanel(this);

    public Temp2() {
        setLayout(cardLayout);
        add(introPanel, IntroPanel.class.getName());
        add(gamePanel, GamePanel.class.getName());
    }

    public void showCard(String name) {
        cardLayout.show(this, name);
    }

    private static void createAndShowGui() {
        Temp2 mainPanel = new Temp2();

        JFrame frame = new JFrame("Temp2");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}