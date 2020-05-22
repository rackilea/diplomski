import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TestFontLayout extends JPanel {

    public enum AnchorPoint{
        UPPER_LEFT,
        TOP_CENTER,
        UPPER_RIGHT,
        RIGHT_CENTER,
        LOWER_RIGHT,
        BOTTOM_CENTER,
        LOWER_LEFT,
        LEFT_CENTER,
        CENTER
    };

    public void drawText(TextLayout text, AnchorPoint point, Graphics2D g2, float x, float y) {
        float translationX = 0.0f;
        float translationY = 0.0f;

        Rectangle2D bounds = text.getBounds();
        float midYOffset = (float) bounds.getHeight()/2;
        float midXOffset = (float) -bounds.getWidth()/2;

        float topYOffset = (float) bounds.getHeight();
        float bottomYOffset = 0.0f;

        float leftXOffset = 0.0f;
        float rightXOffset = (float) -bounds.getWidth();

        // Adjust x values
        switch (point) {
            // Left
            case UPPER_LEFT:
            case LOWER_LEFT:
            case LEFT_CENTER:
                translationX = leftXOffset;
                break;
                // Mid
            case TOP_CENTER:
            case BOTTOM_CENTER:
            case CENTER:
                translationX = midXOffset;
                break;
            // Right
            case UPPER_RIGHT:
            case RIGHT_CENTER:
            case LOWER_RIGHT:
                translationX = rightXOffset;
        }

        // Adjust y values
        switch (point) {
            // Top
            case UPPER_LEFT:
            case UPPER_RIGHT:
            case TOP_CENTER:
                translationY = topYOffset;
                break;
            // Mid
            case LEFT_CENTER:
            case CENTER:
            case RIGHT_CENTER:
                translationY = midYOffset;
                break;
            // Bottom
            case LOWER_LEFT:
            case BOTTOM_CENTER:
            case LOWER_RIGHT:
                translationY = bottomYOffset;
        }

        text.draw(g2, x + translationX, y + translationY);

    }

    public TestFontLayout() {
        super();
        setPreferredSize(new Dimension(400,400));
    }
    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        // Ensure that the default painting occurs
        super.paintComponent(g);

        Point2D loc = new Point2D.Double(getWidth()/2,getHeight()/2);
        Font font = Font.decode("Helvetica");
        FontRenderContext frc = g2.getFontRenderContext();
        TextLayout layout = new TextLayout("This is a string", font, frc);

        g2.setColor(Color.RED);
        g2.drawRect(getWidth()/2, getHeight()/2, 1,1);

        g2.setColor(Color.PINK);
        drawText(layout, AnchorPoint.UPPER_LEFT, g2, 0, 0);

        g2.setColor(Color.BLUE);
        drawText(layout, AnchorPoint.TOP_CENTER, g2, getWidth()/2, 0);

        g2.setColor(Color.ORANGE);
        drawText(layout, AnchorPoint.UPPER_RIGHT, g2, getWidth(), 0);

        g2.setColor(Color.CYAN);
        drawText(layout, AnchorPoint.RIGHT_CENTER, g2, getWidth(), getHeight()/2);

        g2.setColor(Color.ORANGE);
        drawText(layout, AnchorPoint.LOWER_RIGHT, g2, getWidth(), getHeight());

        g2.setColor(Color.BLACK);
        drawText(layout, AnchorPoint.BOTTOM_CENTER, g2, getWidth()/2, getHeight());


        g2.setColor(Color.YELLOW);
        drawText(layout, AnchorPoint.LOWER_LEFT, g2, 0, getHeight());

        g2.setColor(Color.DARK_GRAY);
        drawText(layout, AnchorPoint.LEFT_CENTER, g2, 0, getHeight()/2);


        g2.setColor(Color.MAGENTA);
        drawText(layout, AnchorPoint.CENTER, g2, getWidth()/2, getHeight()/2);
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("");
        frame.add(new TestFontLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }
}