import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Arc2D;
import java.awt.geom.Line2D;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class CircleFrame extends JFrame implements MouseMotionListener {

    private JLabel hoveredLabel;
    private CirclePanel circle;

    public CircleFrame(){
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        circle = new CirclePanel(8, new Dimension(500,500));
        hoveredLabel = new JLabel("");
        hoveredLabel.setFont(new Font("Arial", Font.PLAIN, 50));
        add(circle, BorderLayout.CENTER);
        add(hoveredLabel, BorderLayout.EAST);
        addMouseMotionListener(this);
        pack();
        repaint();
        setVisible(true);
    }

    public static void main(String[] args){
        new CircleFrame();
    }

    static class CirclePanel extends JPanel{

        private static final Color CIRCLE_COLOR = Color.black;
        private static final Color NUMB_COLOR = Color.blue;
        private static final int MARGIN = 50;

        private Path2D.Float[] slices;
        private final int divisions;
        private final int minDimen;
        private Point2D.Float centerPoint;
        private int diameter;

        public CirclePanel(final int d, Dimension size){
            setPreferredSize(size);

            minDimen = Math.min(size.height, size.width);
            final int center = (minDimen - MARGIN) / 2; //center x and y
            centerPoint = new Point2D.Float(center, center);
            diameter = minDimen - MARGIN * 2;
            final Rectangle2D.Float bounds = new Rectangle2D.Float(center - diameter/2, 
                    center - diameter/2, diameter, diameter);

            //Create slices
            slices = new Path2D.Float[d];
            divisions = d;

            for(int i = 0; i < d; i++){

                //Here's where the ordering happens. Use j from here on out to
                //Put slices in in your order
                int j = -1;
                if(i < divisions/2){
                    j = divisions/2 - i;
                }else{
                    j = i + 1;
                }

                Path2D.Float slice = new Path2D.Float();
                float start = fracToRad(j-1, d);
                float end = fracToRad(j,d);
                //Add straight line leaving center
                Point2D.Float arcP1 = rotatedPoint(centerPoint, diameter, start);
                slice.append(new Line2D.Float(center, center, arcP1.x, arcP1.y), true);

                //Add arc
                slice.append(new Arc2D.Float(bounds, (float)Math.toDegrees(start), 
                        (float)Math.toDegrees(fracToRad(1, d)), Arc2D.OPEN), true);

                //Add line back
                Point2D.Float arcP2 = rotatedPoint(centerPoint, diameter, end);
                slice.append(new Line2D.Float(arcP2.x, arcP2.y, center, center), true);

                //Close the slice
                slice.closePath();
                slices[i] = slice;
            }
        }

        @Override
        public void paintComponent(Graphics g){


            Graphics2D g2d = (Graphics2D)g;
            g2d.setColor(CIRCLE_COLOR);
            g2d.setStroke(new BasicStroke(minDimen/ 50));
            for(Shape s : slices){
                g2d.draw(s);
            }

            g2d.setColor(NUMB_COLOR);
            //Draw the numbering
            final int numbRadius = (int)((double) (diameter/2) * .75); //Radius at which to put numbers
            final int numbDiameter = 2 * numbRadius;
            g2d.setFont(new Font("Arial", Font.PLAIN, 25));
            for(int i = 0; i < divisions; i++){

                //Here's where the ordering happens. i is position, j is printed string
                int j = -1;
                if(i < divisions/2){
                    j = divisions/2 - i;
                }else{
                    j = i + 1;
                }

                Point2D.Float loc = rotatedPoint(centerPoint, numbDiameter, 
                        fracToRad(i, divisions) + (float)(2 * Math.PI / (divisions * 2)));
                g2d.drawString(j + "", (int)loc.x, (int)loc.y);
            }
        }

        /** Returns the point on the circle.
         * @param center        - the center of the circle
         * @param diameter      - the diameter of the circle
         * @param rad           - The radians to rotate. 0 is straight right. Rotates counter clockwise
         */
        private static Point2D.Float rotatedPoint(Point2D.Float center, double diameter, double rad){
            double radius = diameter/2;
            return new Point2D.Float((float)(Math.cos(rad) * radius + center.x), (float)(- Math.sin(rad) * radius + center.y));
        }

        /** Returns the number of radians corresponding to the given fraction of a circle */
        public static float fracToRad(int num, int denom){
            return (float)(((double)num) / ((double)denom) * 2 * Math.PI);
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        if(circle == null) return;
        for(int i = 0; i < circle.slices.length; i++){
            if(circle.slices[i].contains(e.getPoint())){
                hoveredLabel.setText((i+1) + "");
                pack();
                repaint();
            }

        }
    }

}