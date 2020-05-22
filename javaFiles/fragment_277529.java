import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class GraphicsPanel extends JPanel {

    private List<Rectangle> rectangles = new ArrayList<Rectangle>();

    public void addRectangle(Rectangle rectangle) {
        rectangles.add(rectangle);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Rectangle rectangle : rectangles) {
            rectangle.drawItself(g);
        }
    }
}