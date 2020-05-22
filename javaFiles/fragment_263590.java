import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Main {
    private static final int verticalGap = 50;
    private static final int horizontalGap = 30;
    private static final int width = 800;
    private static final int height = 800;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main().initUI();
            }
        });
    }

    private void initUI() {
        FlowLayout layout = new FlowLayout(FlowLayout.LEADING, horizontalGap, verticalGap);
        JButton button = new JButton("Discard");
        ImagePanel[] panels = new ImagePanel[5];
        Deck deck = new Deck();
        JFrame frame = new JFrame("Poker");
        frame.setSize(width, height);
        frame.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        deck.mix();
        JPanel deckPanel = new JPanel(layout);
        for (int i = 0; i < 5; i++) {
            panels[i] = new ImagePanel();
            panels[i].setImage(deck.getCard(i));
            deckPanel.add(panels[i]);
        }
        frame.getContentPane().add(deckPanel);
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(button);
        frame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();// Sets the frame size to its preferred size.
        // You can also call setSize() instead
        frame.setVisible(true);
    }
}