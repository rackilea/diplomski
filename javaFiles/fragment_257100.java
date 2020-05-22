package twoBalls;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import javax.swing.JPanel;

public class DrawingPanel extends JPanel {

    private static final long serialVersionUID = -3709678584255542338L;

    private boolean drawLine;

    private int pos;
    private int total;

    private GUIModel guiModel;

    public DrawingPanel(GUIModel guiModel) {
        this.guiModel = guiModel;
        this.drawLine = false;
        this.setPreferredSize(new Dimension(600, 400));
    }

    public boolean isDrawLine() {
        return drawLine;
    }

    public void setDrawLine(boolean drawLine) {
        this.drawLine = drawLine;
    }

    public void setPos(int pos) {
        this.pos = pos;
        repaint();
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        for (Ball ball : guiModel.getBalls()) {
            g2d.setColor(ball.getColor());
            Point center = ball.getCenter();
            int radius = ball.getRadius();
            g2d.fillOval(center.x - radius, center.y - radius, radius + radius,
                    radius + radius);
        }

        if (isDrawLine()) {
            g2d.setColor(Color.BLACK);
            g2d.setStroke(new BasicStroke(5.0F));
            Point a = guiModel.getLineStartPoint();
            Point b = guiModel.getCurrentPoint(pos, total);
            g2d.drawLine(a.x, a.y, b.x, b.y);
        }
    }

}