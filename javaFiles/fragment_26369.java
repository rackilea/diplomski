import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * @see https://stackoverflow.com/a/37293513/230513
 */
public class SimTest {

    private void display() {
        JFrame f = new JFrame("SimTest");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(new Simulation(8));
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    private static class Simulation extends JPanel {

        private final Font font = this.getFont().deriveFont(36f);
        private int count;
        private int data;
        Timer t = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();
                if ((data += 100) == 1000) {
                    t.stop();
                    System.out.println("Saving results…");//generateCsvFile();
                    if (--count == 0) {
                        System.out.println("Fin!");
                        System.exit(0);
                    } else {
                        init();
                        t.restart();
                    }
                }
            }
        });

        public Simulation(int count) {
            this.count = count;
            init();
            t.start();
        }

        private void init() {
            data = 0;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setFont(font);
            g.drawString(String.valueOf(data), 8, g.getFontMetrics().getHeight());
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(256, 128);
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new SimTest()::display);
    }
}