import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.*;

public class SomeShapes extends JPanel {
    private ShapePanel shapePanel = new ShapePanel();
    private JComboBox<MyShape> myShapeCombo = new JComboBox<>(MyShape.values());

    public SomeShapes() {
        myShapeCombo.setSelectedIndex(-1);
        myShapeCombo.addItemListener(new ComboListener());

        JPanel bottomPanel = new JPanel();
        bottomPanel.add(myShapeCombo);

        setLayout(new BorderLayout());
        add(shapePanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.PAGE_END);
    }

    private class ComboListener implements ItemListener {
        @Override
        public void itemStateChanged(ItemEvent e) {
            MyShape myShape = (MyShape) e.getItem();
            shapePanel.drawShapes(myShape);
        }
    }

    private static void createAndShowGui() {
        JFrame frame = new JFrame("SomeShapes");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new SomeShapes());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGui();
            }
        });
    }
}

enum MyShape {
    OVAL("Oval"), RECTANGLE("Rectangle"), SQUARE("Square"), CIRCLE("Circle");
    private String name;

    private MyShape(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return getName();
    }

}

class ShapePanel extends JPanel {
    private static final int PREF_W = 600;
    private static final int PREF_H = PREF_W;
    private static final Color SHAPE_COLOR = Color.BLUE;
    private static final int SHAPE_COUNT = 20;
    private static int MIN = 5;
    private static int MAX = 200;
    private List<Shape> shapeList = new ArrayList<>();
    private Random random = new Random();

    @Override
    public Dimension getPreferredSize() {
        if (isPreferredSizeSet()) {
            return super.getPreferredSize();
        }
        return new Dimension(PREF_W, PREF_H);
    }

    public void drawShapes(MyShape myShape) {
        shapeList.clear();  // empty the shapeList
        switch (myShape) {
        case OVAL:
            drawOval();
            break;
        case RECTANGLE:
            drawRectangle();
            break;
            // etc...

        default:
            break;
        }
        repaint();
    }

    private void drawOval() {
        // for loop to do this times SHAPE_COUNT(20) times.
        for (int i = 0; i < SHAPE_COUNT; i++) {
            // first create random width and height
            int w = random.nextInt(MAX - MIN) + MIN;
            int h = random.nextInt(MAX - MIN) + MIN;

            // then random location, but taking care so that it 
            // fully fits into our JPanel
            int x = random.nextInt(getWidth() - w);
            int y = random.nextInt(getHeight() - h);

            // then create new Shape and place in our shapeList.
            shapeList.add(new Ellipse2D.Double(x, y, w, h));
        }
    }

    private void drawRectangle() {
        // .... etc
    }

    //.. .. etc

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;

        // set rendering hints for smooth ovals
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.setColor(SHAPE_COLOR);
        // iterate through the shapeList ArrayList
        for (Shape shape : shapeList) {
            g2d.draw(shape);  // and draw each Shape it holds
        }            
    }
}