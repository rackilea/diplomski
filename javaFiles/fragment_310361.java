import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

@SuppressWarnings("serial")
public class GetDimension extends JPanel {

    private static final int PREF_W = 600;
    private static final int PREF_H = PREF_W;
    private Point pointStart = null;
    private Point pointEnd = null;

    public GetDimension() {
        this.setBorder(UIManager.getBorder("ComboBox.border"));
        this.repaint();

        MouseAdapter myMouse = new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                pointStart = e.getPoint();
                repaint();
            }

            public void mouseDragged(MouseEvent e) {
                pointEnd = e.getPoint();
                repaint();
            }
        };

        addMouseListener(myMouse);
        addMouseMotionListener(myMouse);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (pointStart != null && pointEnd != null) {
            g.setColor(Color.GREEN);
            g.drawLine(pointStart.x, pointStart.y, pointEnd.x, pointEnd.y);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        if (isPreferredSizeSet()) {
            return super.getPreferredSize();
        }
        return new Dimension(PREF_W, PREF_H);
    }

    private static void createAndShowGui() {
        GetDimension mainPanel = new GetDimension();

        JFrame frame = new JFrame("GetDimension");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            createAndShowGui();
        });
    }
}