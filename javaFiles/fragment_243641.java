import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.Arc2D;

import javax.swing.*;

@SuppressWarnings("serial")
public class ColorArc extends JPanel {
    private static final int PREF_W = 600;
    private static final int PREF_H = 450;
    private int arcX = 150;
    private int arcY = 150;
    private float hue = 0.5f;
    private float saturation = 0.5f;
    private float brightness = 0.5f;
    private Color arcColor = Color.getHSBColor(hue, saturation, brightness);
    private Arc2D myArc = new Arc2D.Double(arcX, arcY, 300, 300, 45, 90, Arc2D.PIE);

    public ColorArc() {
        addKeyListener(new MyKey());
        setFocusable(true);
        requestFocusInWindow();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (myArc != null) {
            Graphics2D g2 = (Graphics2D) g;            
            // use rendering hints to help draw a smooth graphic
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setPaint(arcColor);
            g2.fill(myArc);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        if (isPreferredSizeSet()) {
            return super.getPreferredSize();
        }
        return new Dimension(PREF_W, PREF_H); // set GUI's preferred size
    }

    private class MyKey extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            if (keyCode == KeyEvent.VK_UP) {
                hue += 0.01f;
                hue %= 1.0f;
            } else if (keyCode == KeyEvent.VK_LEFT) {
                saturation += 0.01f;
                saturation %= 1.0f;
            } else if (keyCode == KeyEvent.VK_RIGHT) {
                brightness += 0.01f;
                brightness %= 1.0f;
            } else {
                return;
            }
            arcColor = Color.getHSBColor(hue, saturation, brightness);
            repaint();
        }
    }

    private static void createAndShowGui() {
        ColorArc mainPanel = new ColorArc();

        JFrame frame = new JFrame("Color Arc");
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