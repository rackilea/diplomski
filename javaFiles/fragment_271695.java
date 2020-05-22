import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * <code>MainWindow</code>.
 */
public class MainWindow {
    private JPanel panelMain = new JPanel();

    private JButton buttonCalculate = new JButton("Calculate");

    private JPanel panelPlot; // panel is not added to any container

    public MainWindow() {
        buttonCalculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelPlot = new MyPanel();
                panelPlot.setOpaque(true);
                panelPlot.setBackground(Color.CYAN);
                panelPlot.setPreferredSize(new Dimension(200, 200));
                panelMain.add(panelPlot);
                panelMain.revalidate(); // cause layout manager to recalculate component bounds
            }
        });
        panelMain.add(buttonCalculate);
    }

    public static void main(String[] args) {
        JFrame f = new JFrame("MyFirstGraphTool");
        f.setContentPane(new MainWindow().panelMain);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(600, 400);
        f.setVisible(true);
    }

    static class MyPanel extends JPanel {
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            int y2 = (int) (40 * Math.random());
            Line2D line = new Line2D.Double(10, 10, 60, y2);
            Rectangle2D rectangle = new Rectangle2D.Double(200, 120, 70, 30);
            Ellipse2D oval = new Ellipse2D.Double(400, 200, 40, 60);
            g2.draw(line);
            g2.setPaint(Color.RED);
            g2.fill(rectangle);
            g2.setPaint(Color.ORANGE);
            g2.fill(oval);
        }
    }
}