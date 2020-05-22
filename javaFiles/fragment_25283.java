import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.RadialGradientPaint;
import javax.swing.*;

@SuppressWarnings("serial")
public class GradOval extends JPanel {
    private static final int PREF_W = 400;
    private static final int PREF_H = PREF_W;
    private static final Color BG = Color.BLACK;
    private static final float[] FRACTIONS = {0.0f, 1.0f};
    private static final Color[] COLORS = {Color.LIGHT_GRAY, new Color(0, 0, 0, 0)};

    public GradOval() {
        setBackground(BG);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        float cx = getWidth() / 2f;
        float cy = getHeight() / 2f;
        float radius = cx;       
        Paint paint = new RadialGradientPaint(cy, cy, radius, FRACTIONS, COLORS);
        Graphics2D g2 = (Graphics2D) g;
        g2.setPaint(paint);
        g2.fillRect(0, 0, getWidth(), getHeight());        
    }

    @Override
    public Dimension getPreferredSize() {
        if (isPreferredSizeSet()) {
            return super.getPreferredSize();
        }
        return new Dimension(PREF_W, PREF_H);
    }

    private static void createAndShowGui() {
        GradOval mainPanel = new GradOval();

        JFrame frame = new JFrame("GradOval");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGui();
            }
        });
    }
}