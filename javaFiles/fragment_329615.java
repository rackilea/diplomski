import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

public class ShapeFactory extends JFrame implements ActionListener {

    public static void main(String[] args) {
        new ShapeFactory();
    }

    JButton ranRects = new JButton("Random Rectangles");
    JButton ranElli = new JButton("Random Ellipses");
    JButton ranLines = new JButton("Random Lines");
    private List<Shape> rectList = new ArrayList<>();
    private List<Shape> ovalList = new ArrayList<>();
    private List<Shape> lineList = new ArrayList<>();

    private class Shape{
        public int x1;
        public int y1;
        public int x2;
        public int y2;
        public Color color;
    }

    public ShapeFactory() {
        super("Shape Factory");
        setLayout(new FlowLayout());
        setSize(600, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        add(ranRects);
        add(ranElli);
        add(ranLines);

        JPanel nPanel = new JPanel(new GridLayout(1, 3));
        nPanel.add(ranRects);
        nPanel.add(ranElli);
        nPanel.add(ranLines);

        add(nPanel);


        ranRects.addActionListener(this);

        ranElli.addActionListener(this);

        ranLines.addActionListener(this);


        setVisible(true);
    }

    public void paint(Graphics g) {
        super.paint(g);
        for (Shape s: rectList )
            paintRect(g, s);
        //...
        //Add loops for all shapes
    }

    public void paintRect(Graphics g, Shape shape) {
        g.setColor(shape.color);
        g.fillRect(shape.x1, shape.y1, shape.x2, shape.y2);
    }
    //...
    //Add paint methods for oval and lines

    public void addRect(){
        //Create new Shape
        Shape shape = new Shape();

        //Set shape's properties
        shape.x1 = (int) (Math.random() * getWidth() / 4.0);
        shape.x2 = (int) (Math.random() * getHeight() / 4.0);
        shape.y1 = (int) (Math.random() * getWidth());
        shape.y2 = (int) (Math.random() * getHeight());
        shape.color =  new Color((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255));
        //Add the shape to the list

        this.rectList.add(shape);
    }
    //...
    //Add methods to add ovals and lines


    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == ranRects) {
            addRect();
        } else if (source == ranElli) {
            //addOval();
        } else if (source == ranLines) {
            //addLine();
        }
        repaint();
    }
}