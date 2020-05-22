import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class TestPanel extends JPanel {

    public List<Line2D> lines = new ArrayList<Line2D>();

    public TestPanel() {
        this.setFocusable(true);
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER) {
                    lines.add(new Line2D.Double(100, lines.size() * 100,
                            300, lines.size() * 100));
                    repaint();
                }
            }
        });
    }

    public void paintComponent(Graphics g) {
        for(Line2D line : lines) {
            g.drawLine((int) line.getX1(), (int) line.getY1(), (int) line.getX2(),
                    (int) line.getY2());
        }
    }

    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        TestPanel p = new TestPanel();
        f.add(p);
        f.setSize(1000, 1000);
        f.setVisible(true);
    }
}