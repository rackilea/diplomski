package Main;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import javax.swing.JSlider;

public class ReversedJSlider extends JSlider{
private static final long serialVersionUID = 1L;

    public ReversedJSlider() {
        super();
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        AffineTransform tx = new AffineTransform();
        tx.translate(50, 0);
        tx.scale(-1, 1);
        tx.translate(-50, 0);
        g2d.setTransform(tx);
        super.paintComponent(g2d);
    }

}