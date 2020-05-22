import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/** @see https://stackoverflow.com/questions/6333464 */
public class RotatePanel extends JPanel {

    public RotatePanel() {
        this.setPreferredSize(new Dimension(320, 240));
        this.add(new JLabel("Hello World!", JLabel.CENTER));
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        int w2 = getWidth() / 2;
        int h2 = getHeight() / 2;
        g2d.rotate(-Math.PI / 2, w2, h2);
        super.paintComponent(g);
    }

    private void display() {
        JFrame f = new JFrame("RotatePanel");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(this);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new RotatePanel().display();
            }
        });
    }
}