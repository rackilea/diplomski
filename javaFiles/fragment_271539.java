import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JViewport;

public @SuppressWarnings("serial") class GradientViewport extends JViewport {
    private Color c1;
    private Color c2;

    public GradientViewport(Color c1, Color c2) {
        this.c1 = c1;
        this.c2 = c2;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        GradientPaint gPaint = new GradientPaint(0, 0, c1, getWidth(), getHeight(), c2, false);
        Graphics2D g2 = (Graphics2D) g;
        g2.setPaint(gPaint);
        g2.fillRect(0, 0, getWidth(), getHeight());
    }

}