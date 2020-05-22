import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import javax.swing.Icon;
import javax.swing.JOptionPane;

public class TestIcon {

    public static void main(String[] args) {
        myIcon icn = new myIcon(40, 50);
        JOptionPane.showMessageDialog(null, "Hello World!", "Message", JOptionPane.INFORMATION_MESSAGE, icn);
    }

    public static class myIcon implements Icon {

        private int width;
        private int height;

        public myIcon(int width, int height) {
            this.width = width;
            this.height = height;
        }

        public int getIconWidth() {
            return width;   
        }

        public int getIconHeight() {
            return height;
        }

        public void paintIcon(Component c, Graphics g, int x, int y) {
            Graphics2D g2 = (Graphics2D) g;
            Ellipse2D.Double ellipse = new Ellipse2D.Double(x, y, width, height);

            g2.setColor(Color.RED);
            g2.fill(ellipse);
        }
    }

}