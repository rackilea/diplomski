import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Stroke;
import javax.swing.JPanel;

public @SuppressWarnings("serial")
class NumberLine3 extends JPanel {
    private static final double X_GAP = 1.0 / 20.0;
    private static final double MAJOR_TIC_HT = 0.4;
    private static final int PREF_W = 600;
    private static final int PREF_H = 50;
    private static final Stroke MAIN_STROKE = new BasicStroke(5f);
    private static final Stroke MAJOR_TIC_STOKE = new BasicStroke(3f);
    private static final int CIRCLE_WIDTH = 20;
    private static final Color VALUE_COLOR = new Color(32, 230, 2);
    private int maxX;
    private int majorTickCount;
    private int minorTicksPerMajor;
    private double value;

    public NumberLine3(int maxX, int majorTickCount, int minorTicksPerMajor, double value) {
        this.maxX = maxX;
        this.majorTickCount = majorTickCount;
        this.minorTicksPerMajor = minorTicksPerMajor;
        this.value = value;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        // rendering hints to smooth out your drawing
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        Graphics2D g2b = (Graphics2D) g2.create(); // so we can change stroke without problems
        g2b.setStroke(MAIN_STROKE);
        int x1 = (int) xValueToScreen(-maxX);
        int y1 = getHeight() / 2;
        int x2 = (int) xValueToScreen(maxX);
        int y2 = y1;
        g2b.drawLine(x1, y1, x2, y2);
        g2b.setStroke(MAJOR_TIC_STOKE);
        for (int i = 0; i <= 2 * majorTickCount; i++) {
            double xVal = ((double) i * maxX) / majorTickCount - maxX;
            x1 = (int) xValueToScreen(xVal);
            x2 = x1;
            double dY1 = getHeight() * (1 - MAJOR_TIC_HT) / 2.0;
            if (i == majorTickCount) {
                dY1 = 0.5 * dY1;
            }
            double dY2 = getHeight() - dY1;
            g2b.drawLine(x1, (int) dY1, x2, (int) dY2);
        }
        g2b.dispose();

        g2.setColor(VALUE_COLOR);
        x1 = (int) (xValueToScreen(value) - CIRCLE_WIDTH / 2.0);
        y1 = (int) (getHeight() - CIRCLE_WIDTH) / 2;
        g2.fillOval(x1, y1, CIRCLE_WIDTH, CIRCLE_WIDTH);
    }

    private double xValueToScreen(double xValue) {
        double gap = getWidth() * X_GAP;
        double scale = (double) (getWidth() - 2 * gap) / (2 * maxX);
        return (xValue + maxX) * scale + gap;
    }

    @Override
    public Dimension getPreferredSize() {
        if (isPreferredSizeSet()) {
            return super.getPreferredSize();
        }
        return new Dimension(PREF_W, PREF_H);
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
        repaint();
    }

    public int getMaxX() {
        return maxX;
    }

    public int getMajorTickCount() {
        return majorTickCount;
    }

    public int getMinorTicksPerMajor() {
        return minorTicksPerMajor;
    }
}