import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyWindow {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MyWindow().qwe();
            }
        });
    }

    void qwe() {
        JFrame frame = new JFrame("qwe");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MyPanel panel = new MyPanel();
        panel.setLayout(null);
        frame.add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static class MyPanel extends JPanel {

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawRect(50, 50, 90, 70);
            addShape(g);
        }

        public void addShape(Graphics g) {
            g.drawString("qwe", 20, 20);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(300, 200);
        }
    }
}