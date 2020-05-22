import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.*;

public class DrawStringPanel extends JPanel {
    private static final String[] TEXTS = {
            "One", "Two", "Three", "Four", "Five", 
            "Six", "Seven", "Eight", "Nine", "Ten"
            };
    private static final int PREF_W = 400;
    private static final int PREF_H = PREF_W;
    private static final Font TEXT_FONT = new Font(Font.SANS_SERIF, Font.BOLD, 40);
    private static final int TEXT_X = 150;
    private static final int TEXT_Y = 200;
    private int index = 0;

    // Note that this String variable holds the first item in the TEXTS array
    private String currentString = TEXTS[index];

    public DrawStringPanel() {
        setPreferredSize(new Dimension(PREF_W, PREF_H));
        JButton nextBtn = new JButton("Next");
        add(nextBtn);
        nextBtn.addActionListener(e -> {
            // update the array index
            index++;  // get next index
            index %= TEXTS.length;  // but don't let get bigger then array length

            // and in the ActionListener here I'm changing the variable and calling repaint
            // this works because this variable is actually painted within this JPanel's 
            // paintComponent method....
            currentString = TEXTS[index];
            repaint();
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g2.setFont(TEXT_FONT);

        // ****** HERE ****** I draw the contents of the currentString variable
        g2.drawString(currentString, TEXT_X, TEXT_Y);
    }

    private static void createAndShowGui() {
        DrawStringPanel mainPanel = new DrawStringPanel();

        JFrame frame = new JFrame("DrawStringPanel");
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