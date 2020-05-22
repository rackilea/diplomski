import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Game {
    private JFrame frame;
    private JButton button;
    private boolean status;
    private JPanel[] cards;
    private CardLayout cl;
    private JPanel gamePane;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Game().createAndShowGUI());
    }

    private void createAndShowGUI() {
        frame = new JFrame(getClass().getSimpleName());
        button = new JButton("Switch Worlds");
        status = true; //True = Inner / False = Outer

        cl = new CardLayout();

        gamePane = new JPanel(cl);
        cards = new JPanel[2];

        cards[0] = new InnerWorld();
        cards[1] = new OuterWorld();

        gamePane.add(cards[0], "innerWorld");
        gamePane.add(cards[1], "outerWorld");

        button.addActionListener(e -> {
            status = !status;
            if (status) {
                cl.show(gamePane, "innerWorld");
            } else {
                cl.show(gamePane, "outerWorld");
            }
        });

        frame.add(gamePane);
        frame.add(button, BorderLayout.SOUTH);

        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

@SuppressWarnings("serial")
class InnerWorld extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        g2d.drawString("Inner World", 50, 50);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(200, 200);
    }
}

@SuppressWarnings("serial")
class OuterWorld extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        g2d.drawString("Outer World", 50, 50);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(200, 200);
    }
}