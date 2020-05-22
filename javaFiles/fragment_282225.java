import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ParabolicCurves extends JFrame {

    private static final int SIZE = 600;
    private static final int LINE_INCREMENT = 5;
    private static final int NUM_OF_PATTERNS = 4;
    private Random rand = new Random();

    ParabolicCurves()   {

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        JPanel panel = new DrawingPanel(SIZE);
        add(panel, BorderLayout.CENTER);
        pack();
        setVisible(true);
    }

    class DrawingPanel extends JPanel{

        public DrawingPanel(int size) {
            setPreferredSize(new Dimension(size, size));
            setBackground(Color.WHITE);
        }

        @Override
        public void paintComponent(Graphics g) {

            super.paintComponent(g);

            int red, green, blue, delta , iterations;
            int height, width ,startX, startY, endX, endY ;
            Rectangle boundingRrectangle = getBounds();

            for(int pattern = 0 ; pattern < NUM_OF_PATTERNS; pattern++) {

                red = rand.nextInt(128) + 128;
                green = rand.nextInt(128) + 128;
                blue = rand.nextInt(128) + 128;
                g.setColor(new Color(red,green,blue));

                height = (int) boundingRrectangle.getHeight();
                width = (int) boundingRrectangle.getWidth();
                startX = (int) boundingRrectangle.getX();
                startY = (int) boundingRrectangle.getY();
                endX = startX+width;
                endY = startY+ height;

                iterations = Math.min(width, height)/LINE_INCREMENT;
                delta = 0;
                for (int x = 0; x < iterations ; x++) {

                    g.drawLine(startX, startY+delta, startX+delta, endY);
                    g.drawLine(endX, startY+delta, startX+delta, startY);
                    delta += LINE_INCREMENT;
                }
                //change bounding rectangle 
                boundingRrectangle = new Rectangle(startX+(width/4),
                                                startY+(width/4), width/2, height/2);
            }
        }
    }

    public static void main(String[] args)  {
        new ParabolicCurves();
    }
}