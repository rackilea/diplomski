import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.*;

@SuppressWarnings("serial")
public class DrawCircle extends JPanel {
    private static final int PANEL_WIDTH = 600;
    private static final Color CIRCLE_COLOR = Color.GREEN;
    private int posx;
    private int posy;
    private int diameter;

    public DrawCircle(int posx, int posy, int diamter) {
        setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_WIDTH));
        this.posx = posx;
        this.posy = posy;
        this.diameter = diamter;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        // for smooth graphics
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(CIRCLE_COLOR);
        g2.fillOval(posx, posy, diameter, diameter);
    }

    private static void createAndShowGui() {
        DrawCircle mainPanel = new DrawCircle(100, 100, 400);

        JFrame frame = new JFrame("DrawCircle");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}