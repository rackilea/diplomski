import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.GeneralPath;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class PathBorder {

    private JFrame frame;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            public void run() {
                try {
                    PathBorder window = new PathBorder();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public PathBorder() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel() {

            GeneralPath path;

            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON);
                BasicStroke s = new BasicStroke(
                        5.5f, 
                        BasicStroke.CAP_ROUND, 
                        BasicStroke.JOIN_ROUND);
                g2d.setStroke(s);
                g2d.setColor(Color.BLACK);
                if (path==null) {
                    path = new GeneralPath();
                    path.moveTo(0, 0);
                    path.lineTo(100, 100);
                    path.lineTo(200, 100);
                    path.lineTo(100, 80);
                }
                g2d.draw(path);
                g2d.setStroke(new BasicStroke(3));
                g2d.setColor(Color.YELLOW);
                g2d.draw(path);
            }
        };
        frame.setBackground(Color.CYAN);
        frame.add(panel);
    }
}