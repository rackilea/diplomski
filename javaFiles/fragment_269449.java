import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.awt.Polygon;

public class ShiftingButton extends JButton implements ActionListener {

    private Polygon shape;

    public ShiftingButton () {
        setContentAreaFilled(false);
        initialize();
        addActionListener(this);
    }

    protected void initialize() {
        shape = new Polygon();
        setSize(120, 120);
        shape.addPoint(0, 0);
        shape.addPoint(0, 60); 
        shape.addPoint(90, 0);
    }

    @Override
    public Dimension getPreferredSize() {
        return (new Dimension(120, 120));
    }

    // Hit detection
    public boolean contains(int x, int y) {
        return shape.contains(x, y);
    }

    @Override
    protected void paintComponent(Graphics g) {
        System.err.println("paintComponent()");
        super.paintComponent(g);
        g.fillPolygon(shape);       
    }

    protected void paintBorder(Graphics g) {
    }

    @Override
    public void actionPerformed (ActionEvent ev) {
        System.out.println("ShiftingButton ActionEvent!");
    }

    public static void main (String[] args) {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        ShiftingButton button = new ShiftingButton();
        panel.add(button);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}