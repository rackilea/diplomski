import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(460, 500);
        frame.setTitle("Circles generator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
              frame.setVisible(true);
           }
        });

        String input = JOptionPane.showInputDialog("Enter n:");
        CustomComponents0 component = new CustomComponents0();
        frame.add(component);
        frame.getContentPane().validate();
        frame.getContentPane().repaint();
    }

    static class CustomComponents0 extends JLabel {

        private static final long serialVersionUID = 1L;

        @Override
        public Dimension getMinimumSize() {
            return new Dimension(200, 100);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(300, 200);
        }

        @Override
        public void paintComponent(Graphics g) {
            int margin = 10;
            Dimension dim = getSize();
            super.paintComponent(g);
            g.setColor(Color.red);
            g.fillRect(margin, margin, dim.width - margin * 2, dim.height - margin * 2);
        }
    }
}