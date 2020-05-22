import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

/** @see http://stackoverflow.com/questions/7823631 */
public class X extends JPanel {

    private static final int SIZE = 300;
    private static final int INSET = 64;
    private static final AlphaComposite OVER_HALF =
        AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f);
    private boolean src;

    public X(boolean src) {
        this.src = src;
        this.setBackground(Color.lightGray);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(SIZE, SIZE);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(
            RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);
        Line2D line1 = new Line2D.Double(INSET, INSET,
            getWidth() - INSET, getHeight() - INSET);
        Line2D line2 = new Line2D.Double(getWidth() - INSET,
            INSET, INSET, getHeight() - INSET);
        g2.setStroke(new BasicStroke(64,
            BasicStroke.CAP_ROUND,
            BasicStroke.JOIN_BEVEL));
        g2.setComposite(OVER_HALF);
        g2.setColor(Color.red);
        g2.draw(line1);
        if (src) {
            g2.setComposite(AlphaComposite.Src);
        }
        g2.setColor(Color.blue);
        g2.draw(line2);
    }

    public static void main(String[] args) {
        final JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(1, 0));
        frame.add(new X(false));
        frame.add(new X(true));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}