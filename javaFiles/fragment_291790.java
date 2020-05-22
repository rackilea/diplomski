import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class RandomsTest extends JFrame {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.getContentPane().add(new TestPanel());
        frame.setSize(1000, 700);
        frame.setTitle("Random things");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        //frame.setResizable(false);
    }

}

class TestPanel extends JPanel
{
    private List<Geometry> geometries;

    TestPanel()
    {
        geometries = new ArrayList<Geometry>();
        int numGeometries = Randoms.nextInt(5, 8);
        for (int i=0; i<numGeometries; i++)
        {
            geometries.add(new Geometry());
        }
    }

    public void paintComponent(Graphics gr)
    {
        super.paintComponent(gr);
        Graphics2D g = (Graphics2D)gr;
        for (Geometry geometry : geometries)
        {
            geometry.draw(g);
        }
    }
}




class Geometry
{
    private final Color color;
    private final Shape shape;

    Geometry()
    {
        this.color = Randoms.createRandomColor();
        this.shape = Shapes.createRandomShape();
    }

    void draw(Graphics2D g)
    {
        g.setColor(color);
        g.fill(shape);
    }

}

class Shapes
{
    static Shape createRandomShape()
    {
        int type = Randoms.nextInt(2);
        switch (type)
        {
            case 0 : return createRandomOval();
            case 1 : return createRandomRectangle();
        }
        return createRandomOval();
    }

    private static Shape createRandomOval()
    {
        return new Ellipse2D.Double(
            Randoms.nextInt(800),
            Randoms.nextInt(800),
            Randoms.nextInt(800),
            Randoms.nextInt(800));
    }

    private static Shape createRandomRectangle()
    {
        return new Rectangle2D.Double(
            Randoms.nextInt(800),
            Randoms.nextInt(800),
            Randoms.nextInt(800),
            Randoms.nextInt(800));
    }
}

class Randoms
{
    private static final Random random =
        new Random(System.currentTimeMillis());

    public static Color createRandomColor()
    {
        int red = random.nextInt(255);
        int green = random.nextInt(255);
        int blue = random.nextInt(255);
        return new Color(red,green,blue);
    }

    public static int nextInt(int min, int max)
    {
        return random.nextInt(max - min) + min;
    }

    public static int nextInt(int max)
    {
        return random.nextInt(max);
    }
}