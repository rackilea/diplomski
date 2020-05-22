import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;

public class TestDemo extends JPanel implements ActionListener {

    private static final long serialVersionUID = 1L;
    private int x1;
    private int y1;
    Timer timer;

    TestDemo() {
        x1 = 0;
        y1 = 0;
        this.setBackground(Color.BLACK);
        timer = new Timer(10, this);
        timer.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.scale(1, 1);
        g2d.setPaint(Color.RED);
        g2d.fill(new Rectangle2D.Double(getX1(), getY1(), 20, 20));
    }

    public void actionPerformed(ActionEvent e) {
        setX1(getX1() + 1);
        repaint();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Moving star");
        JPanel testDemo = new TestDemo();
        testDemo.setSize(800, 200);
        frame.add(testDemo);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }
}