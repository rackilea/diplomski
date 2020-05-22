import javax.swing.*;
import java.awt.*;

public class ImageTest {

    public static void main(String[] args) {

        JFrame frame = new JFrame();
        JLabel label = new JLabel(new ElliptIcon(380, 260, Color.red));
        label.setLayout(new GridLayout(2, 2));
        frame.setContentPane(label);

        for (int i = 0; i < 4; i++) {
            label.add(new JLabel(new ElliptIcon(100, 60, Color.blue)));
        }

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private static class ElliptIcon implements Icon {

        private int w, h;
        private Color color;

        public ElliptIcon(int w, int h, Color color) {
            this.w = w;
            this.h = h;
            this.color = color;
        }

        @Override
        public void paintIcon(Component c, Graphics g, int x, int y) {
            g.setColor(color);
            g.fillOval(x, y, w, h);
        }

        @Override
        public int getIconWidth() { return w; }

        @Override
        public int getIconHeight() { return h; }
    }
}