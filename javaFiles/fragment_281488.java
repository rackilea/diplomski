import java.awt.BasicStroke;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.RoundRectangle2D;

public class KeyTest extends Canvas {

    /**
     *
     */
    private static final long serialVersionUID = 3L;
    Color color = Color.BLACK;
    private static float borderThickness = 5;
    Shape firstShape = new RoundRectangle2D.Double(20, 40, 300, 50, 10, 10);
    Shape secondShape = new RoundRectangle2D.Double(20, 150, 300, 50, 10, 10);

    Shape highlightedShape;

    public KeyTest() {
        setBackground(Color.RED);
        setSize(700, 750);
    }

    public static void main(final String[] args) {
        Frame frame = new Frame("Test App");
        final KeyTest keyTest = new KeyTest();
        keyTest.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(final KeyEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void keyPressed(final KeyEvent e) {
                int keyCode = e.getKeyCode();

                System.out.println(keyCode);
                System.out.println(KeyEvent.VK_UP);
                if (keyCode == KeyEvent.VK_UP) {
                    System.out.println("Going to move up");
                    keyTest.move(1);

                }
                if (keyCode == KeyEvent.VK_DOWN) {
                    System.out.println("Going to move down");
                    keyTest.move(2);

                }
            }

            @Override
            public void keyReleased(final KeyEvent e) {
                // TODO Auto-generated method stub

            }
        });
        frame.add(keyTest);
        frame.setBackground(Color.RED);
        frame.setLayout(null);
        frame.setSize(700, 750);
        frame.setVisible(true);
    }

    public void paint(final Graphics graphics) {

        Graphics2D graphics2D = (Graphics2D) graphics; //TypeCasting to 2D
        System.out.println("I am inside paint");

        //      Smoothening the corners
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        //      Apple border color
        Stroke oldStroke = graphics2D.getStroke();
        graphics2D.setStroke(new BasicStroke(borderThickness));
        graphics2D.setColor(Color.WHITE);

        //      Drawing a RoundedRectangle for Apple
        graphics2D.draw(firstShape);
        graphics2D.setStroke(oldStroke);

        //      Setting the Background Color
        graphics2D.setColor(Color.BLACK);
        graphics2D.fill(firstShape);

        //      Setting the font inside the shape
        Font firstFont = new Font("Serif", Font.BOLD, 35);
        graphics2D.setFont(firstFont);
        graphics2D.setColor(Color.WHITE);
        graphics2D.drawString("Apple", 30, 80);

        //      Pineapple border color
        graphics2D.setStroke(new BasicStroke(borderThickness));
        graphics2D.setColor(Color.WHITE);

        //      Drawing a RoundedRectangle for Pineapple
        graphics2D.draw(secondShape);
        graphics2D.setStroke(oldStroke);

        //      Setting the Background Color
        graphics2D.setColor(Color.BLACK);
        graphics2D.fill(secondShape);

        //      Setting the font inside the shape
        Font secondFont = new Font("Serif", Font.BOLD, 35);
        graphics2D.setFont(secondFont);
        graphics2D.setColor(Color.WHITE);
        graphics2D.drawString("Pineapple", 30, 190);

        paintHighlightedShape(graphics2D);

    }

    private void paintHighlightedShape(final Graphics2D graphics2D) {

        if (highlightedShape != null) {

            graphics2D.setColor(Color.GREEN);
            graphics2D.fill(highlightedShape);

        }
    }

    public void move(final int shapeNumber) {

        switch (shapeNumber) {
        case 1:
            highlightedShape = firstShape;
            break;
        case 2:
            highlightedShape = secondShape;
            break;
        default:

        }

        System.out.println("Check:" + highlightedShape.getBounds2D());
        System.out.println("Moving shape : " + highlightedShape);
        repaint();

        System.out.println("moving out");

    }
}