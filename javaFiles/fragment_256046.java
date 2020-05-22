import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Bsp {

    public static void main(String[] args) {
        JFrame frame = new MyFrame();
    }
}

class MyFrame extends JFrame {

    private class MyLine extends JLabel {

        int width;

        public MyLine(int width) {
            this.width = width;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.BLACK);
            g.drawLine(0, 0, getWidth(), getHeight());
            g.dispose();
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(width, 16);
        }

    }

    public MyFrame() {

        JLabel label = new MyLine(32);
        System.out.println(getWidth());
        JPanel panel = new JPanel(new GridBagLayout());

        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 1));

        panel.add(label);

        add(new JButton("A"));
        add(new JButton("B"));
        add(panel);
        pack();
        setVisible(true);

    }
}