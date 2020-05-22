import java.awt.*;
import javax.swing.*;  
public class Graph extends JPanel {
   private static final int UNIT = 20;
   protected void paintComponent(Graphics g) {
     int YP1,YP2;
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D)g;

      int h = getHeight();
         int w = getWidth();
         // Draw axeX.
         g2.draw(new Line2D.Double(0, h/2, w, h/2)); //to make axisX in the middle
         // Draw axeY.
         g2.draw(new Line2D.Double(w/2,h,w/2,0));//to make axisY in the middle of the panel

                  //line between P1(0,1) and P2(1,2) to draw function x+1
    Point2D P1 = new Point2D.Double(w/2,(h/2)+ UNIT);
    Point2D P2 = new Point2D.Double((w/2)+ UNIT,(h/2)+ 2*UNIT);  //considering 20 = 1 unit in your syste,
     g2.draw(new Line2D.Double(P1,P2));
}
public static void main(String[] args) {
      JFrame f = new JFrame();
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      f.add(new Graphe());
      f.setSize(400,400);
      f.setLocation(200,200);
      f.setVisible(true);
  }
}