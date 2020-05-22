import javax.swing.JApplet;
import java.util.*;
import java.awt.*;

public class Shapes extends JApplet {

    @Override
    public void init() {
        add(new ShapesPanel());
    }

}    

class ShapesPanel extends JPanel {
    private Random rand = new Random();
    // Declare size constants
    final int circleMax = 160,circleMin = 40; // circle max and min diameter
    final int locMaxX = 360, locMaxY = 260;
    int radiusSize = 0, locationx = 0,locationy = 0 ;

    public ShapesPanel() {
        radiusSize = (rand.nextInt(circleMax)+ circleMin); 
        locationx =20 ;//rand.nextInt(locMaxX)+ 20;
        locationy =20 ;// rand.nextInt(locMaxY) + 20;
    }

    @Override
    protected void paintComponent (Graphics page)   {
        super.paintComponent(page);
        // Draw the circle 1
        page.drawOval(locationx, locationy, radiusSize,radiusSize);
    }
}