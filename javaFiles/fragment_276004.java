import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.*;

public class MyGrafika extends JComponent {
    private static final int PREF_W = 500;
    private static final int PREF_H = PREF_W;
    private static final Color OVAL_COLOR = Color.RED;
    private int ovalX = 200;
    private int ovalY = 200;
    private int ovalWidth = 100;
    private int ovalHeight = 100;

    public MyGrafika() {
        setPreferredSize(new Dimension(PREF_W, PREF_H));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(OVAL_COLOR);
        g2.fillOval(ovalX, ovalY, ovalWidth, ovalHeight);
    }

    private static void createAndShowGui() {
        MyGrafika mainPanel = new MyGrafika();

        JFrame frame = new JFrame("MyGrafika");
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