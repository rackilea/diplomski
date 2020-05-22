import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class TestCustomPainting {

    private static class MyTriangle extends JPanel {

        private final int width;
        private final int height;

        public MyTriangle(int width, int height) {
            this.width = width;
            this.height = height;
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(width, height);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.GREEN);
            g.fillPolygon(new int[] { 0, getWidth(), 0 }, new int[] { 0, 0, getHeight() }, 3);
        }

    }

    protected static void initUI() {
        JFrame frame = new JFrame("test");
        frame.add(new MyTriangle(200, 45), BorderLayout.EAST);
        frame.add(new MyTriangle(85, 600), BorderLayout.WEST);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                initUI();
            }
        });
    }
}