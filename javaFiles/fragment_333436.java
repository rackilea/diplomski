import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class RepaintTest {

    public static void main(String[] args) {
        new RepaintTest();
    }

    public RepaintTest() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException ex) {
                } catch (InstantiationException ex) {
                } catch (IllegalAccessException ex) {
                } catch (UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        private int paintRequests;
        private int paints;
        private int delay = 0;

        public TestPane() {
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        paintRequests++;
                        try {
                            Thread.sleep(delay);
                        } catch (InterruptedException exp) {
                        }
                        System.out.println("tick");
                        repaint();
                    }
                }
            });
            t.setDaemon(true);
            setLayout(new BorderLayout());
            final JSlider slider = new JSlider();
            slider.setMinimum(0);
            slider.setMaximum(2000);
            slider.setPaintTicks(true);
            slider.setMajorTickSpacing(100);
            slider.addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent e) {
                    delay = slider.getValue();
                    paintRequests = 0;
                    paints = 0;
                }
            });
            slider.setValue(0);
            add(slider, BorderLayout.SOUTH);
            t.start();
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            paints++;
            String text = "Paints = " + paints + "; Paint Requests = " + paintRequests;
            Graphics2D g2d = (Graphics2D) g.create();
            FontMetrics fm = g2d.getFontMetrics();
            int x = (getWidth() - fm.stringWidth(text)) / 2;
            int y = ((getHeight() - fm.getHeight()) / 2) + fm.getAscent();
            g2d.drawString(text, x, y);
            g2d.dispose();
        }

    }
}