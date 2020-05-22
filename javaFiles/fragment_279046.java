import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;
import java.awt.geom.NoninvertibleTransformException;
import java.awt.geom.Path2D;
import java.util.Deque;
import java.util.LinkedList;

import javax.swing.event.*;

public class Project3 extends JPanel implements ActionListener {

    public static Project3 p = new Project3();
    Path2D arrow; // !!
    public static
    JTextField 
    num00 = new JTextField("0"), 
    num10 = new JTextField("1"), 
    num01 = new JTextField("1"), 
    num11 = new JTextField("0"),            
    num02 = new JTextField("0"), 
    num12 = new JTextField("0");
    private static Deque<AffineTransform> atStack = new LinkedList<>(); 

    public Project3() {
        setBackground(Color.WHITE);
        arrow = drawArrow(); // !! create the arrow only once
    }

    public Path2D drawArrow() { // !!
        arrow = new Path2D.Double(); // !!
        arrow.setWindingRule(GeneralPath.WIND_EVEN_ODD);
        arrow.moveTo(0, 0);
        arrow.lineTo(0, -100);
        arrow.moveTo(0, -200);
        arrow.lineTo(100, -100);
        arrow.lineTo(50, -100);
        arrow.lineTo(50, 100);
        arrow.quadTo(0, 0, -50, 100);
        arrow.lineTo(-50, -100);
        arrow.lineTo(-100, -100);
        arrow.lineTo(0, -200);
        arrow.closePath();
        arrow.transform(AffineTransform.getTranslateInstance(250, 250)); // !! shift it here
        return arrow;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON); // !!
        // !! g2.translate(250, 250);  // translate the arrow, not Graphics
        GradientPaint gradient = new GradientPaint(0, 0, Color.LIGHT_GRAY, 15,
                15, Color.BLACK, true);
        g2.setPaint(gradient);
        g2.setStroke(new BasicStroke(12, BasicStroke.CAP_ROUND,
                BasicStroke.JOIN_MITER));
        // g2.draw(drawArrow()); // !!  don't re-create the arrow
        g2.draw(arrow);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Project 3");
        frame.setSize(500, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container cp = frame.getContentPane();
        cp.setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        cp.add(panel, BorderLayout.CENTER);
        panel.add(p, BorderLayout.CENTER);
        panel = new JPanel();
        panel.setLayout(new GridLayout(0, 2));
        cp.add(panel, BorderLayout.SOUTH);

        JPanel textPanel = new JPanel();
        textPanel.setLayout(new GridLayout(2, 3));
        panel.add(textPanel);
        num00.setBorder(BorderFactory.createTitledBorder("m00"));
        num10.setBorder(BorderFactory.createTitledBorder("m10"));
        num01.setBorder(BorderFactory.createTitledBorder("m01"));
        num11.setBorder(BorderFactory.createTitledBorder("m11"));
        num02.setBorder(BorderFactory.createTitledBorder("m02"));
        num12.setBorder(BorderFactory.createTitledBorder("m12"));

        textPanel.add(num00);
        textPanel.add(num10);
        textPanel.add(num02);
        textPanel.add(num01);
        textPanel.add(num11);
        textPanel.add(num12);

        JPanel btPanel = new JPanel();
        btPanel.setLayout(new GridLayout(0, 1));
        panel.add(btPanel);
        JButton apply = new JButton("Apply");
        apply.addActionListener(p);
        btPanel.add(apply);
        JButton reset = new JButton("Reset");
        reset.addActionListener(p);
        btPanel.add(reset);

        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
        case "Apply":
            double m00 = Double.parseDouble(num00.getText());
            double m10 = Double.parseDouble(num10.getText());
            double m01 = Double.parseDouble(num01.getText());
            double m11 = Double.parseDouble(num11.getText());
            double m02 = Double.parseDouble(num02.getText());
            double m12 = Double.parseDouble(num12.getText());
            AffineTransform transform = new AffineTransform(m00, m10, m01, m11,
                    m02, m12); 
            arrow.transform(transform);
            atStack.addFirst(transform); // save the transform
            repaint();
            break;
        case "Reset":
            // !! arrow.transform(new AffineTransform(1, 0, 0, 0, 1, 0));
            while (atStack.size() > 0) {
                AffineTransform at = atStack.removeFirst();

                // inverse fails if determinant is 0
                if (at.getDeterminant() == 0) {
                    return;
                }
                try {
                    arrow.transform(at.createInverse());
                } catch (NoninvertibleTransformException e1) {
                    e1.printStackTrace();
                }
            }
            repaint();
            break;
        }
    }

}