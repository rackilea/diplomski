import java.awt.*;
import java.awt.geom.*;
import java.awt.font.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class BoundingBoxRotatedText {

    private JComponent ui = null;
    JLabel output = new JLabel();
    Font font = new Font(Font.SERIF, Font.PLAIN, 20);
    String string = "The quick brown fox jumps over the lazy dog";
    Shape textShape = getShapeOfText(font, string);
    Rectangle2D rectangle = textShape.getBounds2D();

    BoundingBoxRotatedText() {
        initUI();
    }

    public final void initUI() {
        if (ui!=null) return;

        ui = new JPanel(new BorderLayout(4,4));
        ui.setBorder(new EmptyBorder(4,4,4,4));

        ui.add(output);
        output.setIcon(new ImageIcon(getImage()));
    }

    public static Shape getShapeOfText(Font font, String msg) {
        BufferedImage bi = new BufferedImage(
                1, 1, BufferedImage.TYPE_INT_RGB);

        Graphics2D g = bi.createGraphics();

        FontRenderContext frc = g.getFontRenderContext();
        GlyphVector gv = font.createGlyphVector(frc, msg);

        return gv.getOutline();
    }

    public static Shape moveShapeToCenter(Shape shape, int w, int h) {
        Rectangle2D b = shape.getBounds2D();
        double xOff = -b.getX() + ((w - b.getWidth()) / 2d);
        double yOff = -b.getY() + ((h - b.getHeight()) / 2d);
        AffineTransform move = AffineTransform.getTranslateInstance(xOff, yOff);
        return move.createTransformedShape(shape);
    }

    private BufferedImage getImage() {
        int sz = (int)(rectangle.getBounds().width*1.2);
        BufferedImage bi = new BufferedImage(
                sz, sz, BufferedImage.TYPE_INT_RGB);

        Graphics2D g = bi.createGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, sz, sz);

        Shape shape = moveShapeToCenter(textShape, sz, sz);
        g.setColor(Color.GREEN);
        g.fill(shape);
        g.draw(shape);
        g.draw(shape.getBounds());

        AffineTransform rotate45 = AffineTransform.
                getRotateInstance(Math.PI/4, sz/2, sz/2);
        shape = rotate45.createTransformedShape(shape);
        g.setColor(Color.BLUE);
        g.fill(shape);
        g.draw(shape);
        g.draw(shape.getBounds());

        shape = rotate45.createTransformedShape(shape);
        g.setColor(Color.RED);
        g.fill(shape);
        g.draw(shape);
        g.draw(shape.getBounds());

        g.dispose();

        return bi;
    }

    public JComponent getUI() {
        return ui;
    }

    public static void main(String[] args) {
        Runnable r = () -> {
            try {
                UIManager.setLookAndFeel(
                        UIManager.getSystemLookAndFeelClassName());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            BoundingBoxRotatedText o = new BoundingBoxRotatedText();

            JFrame f = new JFrame(o.getClass().getSimpleName());
            f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            f.setLocationByPlatform(true);

            f.setContentPane(o.getUI());
            f.pack();
            f.setMinimumSize(f.getSize());

            f.setVisible(true);
        };
        SwingUtilities.invokeLater(r);
    }
}