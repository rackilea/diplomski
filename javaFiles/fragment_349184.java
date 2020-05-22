import java.awt.geom.Point2D;

public class Game {


 private final static double RADIAN = Math.PI/180;

 public static void main(String [] args) {


     Point2D start = new Point2D.Double(5,0);
     Point2D hq = new Point2D.Double(25,65);

     // step 1
     double distance = 10;
     double x = distance * Math.cos(RADIAN*50);      
     double y = distance * Math.sin(RADIAN*50); 
     Point2D step1 = new Point2D.Double(x, y);

    // step 2
    distance = 5;
    x = distance * Math.cos(RADIAN*90);      
    y = distance * Math.sin(RADIAN*90); 
    Point2D step2 = new Point2D.Double(x, y);

    // step 3
    distance = 8;
    x = distance * Math.cos(RADIAN*45);      
    y = distance * Math.sin(RADIAN*45); 
    Point2D step3 = new Point2D.Double(x, y);

   // step 4
    distance = 2;
    x = distance * Math.cos(RADIAN*180);         
    y = distance * Math.sin(RADIAN*180);    
    Point2D step4 = new Point2D.Double(x, y);



    x = start.getX() + step1.getX() + step2.getX() + step3.getX() + step4.getX();
    y = start.getY() + step1.getY() + step2.getY() + step3.getY() + step4.getY();

    Point2D finalPosition = new Point2D.Double(x, y);

    System.out.println("Distance Travelled: " + finalPosition.distance(start));
    System.out.println("Distance to HQ: " + finalPosition.distance(hq));

    }    
}