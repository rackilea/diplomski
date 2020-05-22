import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractAction;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.Timer;
import javax.swing.UIManager;

/**
* @see http://stackoverflow.com/a/11233735/230513
*/
public class Test {

    private static Spring spring = new Spring();

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                JFrame frame = new JFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(spring);
                frame.add(new JButton(new AbstractAction("Start") {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        spring.start();
                    }
                }), BorderLayout.SOUTH);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                spring.start();
            }
        });
    }

    private static class Spring extends JComponent {

        private static final int SIZE = 500;
        private static final int DELAY = 1000 / 20; // ~20Hz
        private final Icon icon = UIManager.getIcon("OptionPane.informationIcon");
        private final FloatSpring fs = new FloatSpring(42);
        private final int target = 0;
        private final float delta = 1f / SIZE;
        private float elapsed = 0f;
        private Timer timer = new Timer(DELAY, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if ((int) fs.getPosition() < (target + 1)) {
                    timer.stop();
                    return;
                }
                elapsed += delta;
                fs.update(target, elapsed);
                repaint();
            }
        });

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            int x = (getWidth() - icon.getIconWidth()) / 2;
            int y = (int) fs.getPosition();
            icon.paintIcon(this, g, x, y);
            int xc = x + icon.getIconWidth() / 2;
            g.drawLine(xc, 0, xc, y);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(SIZE / 2, SIZE);
        }

        public void start() {
            timer.stop();
            elapsed = 0;
            fs.setPosition(SIZE - icon.getIconHeight());
            fs.setVelocity(0);
            timer.start();
        }
    }
}