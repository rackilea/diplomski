import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Random;
import java.awt.Color;
import java.lang.Math.*;

public class PointsPanel2 extends JPanel
{
     private final int MAX_POINTS = 20000;
     private final int LENGTH = 1;
     private int x,x1,y,y1;
     private Random random;
     double slope,b,c,g;


     public PointsPanel2(){
     random = new Random();
     setBackground(Color.black);
     setPreferredSize(new Dimension(300,300));

 }


 public void paintComponent(Graphics page)
 {
      super.paintComponent(page);
      // Diagonal equation
      // X0, Y0 = (0,0)
      // Xl, Yl = width, height
      // Equation y = aX + b
      // 0 = 0 + b ==> b = 0
      // Yl = aXl ==> a = Yl/Xl

      // Computes the diagonal a coefficient
      double aCoeff = (getHeight()*1.0)/(getWidth()*1.0);
      System.out.println("Xl,Yl, a = " + getWidth() + " " + getHeight() + "   " + aCoeff);

      for(int count = 0; count < MAX_POINTS; count++)
      {

          x = random.nextInt(getWidth()-1) + 1;

          y = random.nextInt(getHeight()-1) + 1;

          x1= x + LENGTH;
          y1= y + LENGTH;

          // Computes the diagonal image of x in order to compare it with y1
          double diagImage = aCoeff * x1;

          slope = x1/y1;
          c = slope*x;
          b = ((-1)*(y))-c;
          g = (-1)*y1;

          //if (b <= g)
          if (diagImage <= y1)
              page.setColor(Color.red);
          else
              page.setColor(Color.green);
          page.drawLine(x,y,x1,y1);
        }
     }
 }