import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RadialGradientPaint;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class APanel extends JPanel{

    APanel(){

        setPreferredSize(new Dimension(600,600));
        setBackground(Color.YELLOW);
        setBorder(new TitledBorder(new LineBorder(new Color(169, 169, 169)),
                "Gradient Circle", TitledBorder.LEADING, TitledBorder.BELOW_TOP, null, null));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw((Graphics2D) g);
    }

    public static void draw(Graphics2D g2d){

        g2d.setColor(Color.RED);
        g2d.fillRect(100,100, 400, 400);
        drawVisibilityCircle(g2d);
    }

    private static void drawVisibilityCircle(Graphics2D g2d){
        Point center = new Point(300, 300);
        float radius = 200;
        float[] dist = { 0f, 1f};
        Color[] colors = { new Color(0, 0, 0, 0), new Color(0, 0, 0, 255)};
        //workaround to prevent background color from showing
        drawBackGroundCircle(g2d, radius, Color.WHITE, center);
        drawGradientCircle(g2d, radius, dist, colors, center);
    }

    private static void drawBackGroundCircle(Graphics2D g2d, float radius, Color color, Point2D center){

        g2d.setColor(color);
        radius -= 1;//make radius a bit smaller to prevent fuzzy edge
        g2d.fill(new Ellipse2D.Double(center.getX() - radius, center.getY()
                                                    - radius, radius * 2, radius * 2));
    }

    private static void drawGradientCircle(Graphics2D g2d, float radius, float[] dist, Color[] colors, Point2D center){
        RadialGradientPaint rgp = new RadialGradientPaint(center, radius, dist, colors);
        g2d.setPaint(rgp);
        g2d.fill(new Ellipse2D.Double(center.getX() - radius, center.getY() - radius, radius * 2, radius * 2));
    }

    public static void main(String[] args){

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        JPanel panel = new APanel();
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}