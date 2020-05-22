import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JLabel;

/** @see https://stackoverflow.com/a/44212328/230513 */
public class Main {

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new JFrame();
            frame.setTitle("Circles generator");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            CustomComponent component = new CustomComponent();
            frame.add(component);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
            EventQueue.invokeLater(() -> { System.out.println("work before"); });
            EventQueue.invokeLater(() -> { frame.repaint(); });
            EventQueue.invokeLater(() -> { System.out.println("work"); });
            EventQueue.invokeLater(() -> { frame.repaint(); });
            EventQueue.invokeLater(() -> { System.out.println("work after"); });
        });
    }

    static class CustomComponent extends JLabel {

        private static final int N = 10;

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(300, 200);
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            System.out.println("paint");
            g.setColor(Color.red);
            g.fillRect(N, N, getWidth() - N * 2, getHeight() - N * 2);
        }
    }
}