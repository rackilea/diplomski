package bb.view;

import javax.swing.JComponent;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import static bb.BBConfig.SCREEN_WIDTH_PX;   // 304
import static bb.BBConfig.SCREEN_HEIGHT_PX;  // 256

public class Resizer extends JPanel {
    private static final int K = 3;
    private static final Dimension PREF_SIZE =
        new Dimension(K * SCREEN_WIDTH_PX, K * SCREEN_HEIGHT_PX);
    private static final AffineTransform SCALE_XFORM =
        AffineTransform.getScaleInstance(K, K);

    public Resizer(JComponent component) {
        setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        add(component);
    }

    @Override
    public Dimension getPreferredSize() {
        return PREF_SIZE;
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setTransform(SCALE_XFORM);
        super.paint(g2);
    }
}