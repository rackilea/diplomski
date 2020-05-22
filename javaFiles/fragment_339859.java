import java.awt.Graphics;
import javax.swing.JPanel;

public class View extends JPanel{
    private final Model model;

    public View(Model model) {
        this.model = model;
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);

        //center of view panel, in pixels:
        int xCenter = getWidth()/2;
        int yCenter = getHeight()/2;

        int radius = model.getRadius();
        int xStart = xCenter - radius;
        int yStart = yCenter - radius;
        int xWidth = 2 * radius;
        int yHeight = 2 * radius;
        g.setColor(model.getColor());

        g.clearRect(0, 0, getWidth(), getHeight());

        if (model.isSolid()){
            g.fillOval(xStart, yStart, xWidth, yHeight);
        } else {
            g.drawOval(xStart, yStart, xWidth, yHeight);
        }        
    }
}