import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;
import javax.swing.*;

public class CustomPainting {

    private RectangleComponent life;
    private RectangleComponent death;

    private void createAndDisplayGUI() {
        JFrame frame = new JFrame("Custom Painting");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(0, 2, 5, 5));
        // Specifying the WIDTH, HEIGHT and Colour for this JComponent.
        life = new RectangleComponent(Color.GREEN.darker(), 20, 20);
        death = new RectangleComponent(Color.RED.darker(), 20, 20);
        centerPanel.add(life);
        centerPanel.add(death);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
        JButton incLifeButton = new JButton("INCREASE LIFE");
        incLifeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                life.addLife(1);
            }
        });

        JButton decLifeButton = new JButton("DECREASE LIFE");
        decLifeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                life.subtractLife(1);
            }
        });

        JButton incDeathButton = new JButton("INCREASE DEATH");
        incDeathButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                death.addLife(1);
            }
        });

        JButton decDeathButton = new JButton("DECREASE DEATH");
        decDeathButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                death.subtractLife(1);
            }
        }); 

        buttonPanel.add(incLifeButton);
        buttonPanel.add(decLifeButton);
        buttonPanel.add(incDeathButton);
        buttonPanel.add(decDeathButton);

        frame.getContentPane().add(centerPanel, BorderLayout.CENTER);
        frame.getContentPane().add(buttonPanel, BorderLayout.PAGE_END);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String\u005B\u005D args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CustomPainting().createAndDisplayGUI();
            }
        });
    }
}

class RectangleComponent extends JComponent {

    private Color colour;
    private static final int MARGIN = 10;
    private int width;
    private int height;
    private int originalWidth;
    private RoundRectangle2D roundedRectangle;

    public RectangleComponent(Color c, int w, int h) {
        colour = c;
        width = w;
        height = h;
        originalWidth = width;
    }

    /*
     * Overriding this method, so that
     * the size of the JComponent
     * can be determined, on the screen
     * or by the LayoutManager concern.
     */
    @Override 
    public Dimension getPreferredSize() {
        return (new Dimension(width, height));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        roundedRectangle = new RoundRectangle2D.Float(MARGIN, MARGIN,
                                        width, height, MARGIN, MARGIN);
        g2d.setPaint(colour);
        g2d.draw(roundedRectangle);
        g2d.fill(roundedRectangle);
    }

    public void subtractLife(int amount) {
        width -= amount;
        System.out.println("ORIGINAL Width : " + originalWidth);
        System.out.println("Width : " + width);
        if (width > 0) {
            roundedRectangle.setRoundRect(MARGIN, MARGIN, width, height,
                                            MARGIN, MARGIN);
            /*
             * This repaint() will call the paintComponent(...)
             * by itself, so nothing else to be done.
             */
            repaint();
        } else {
            width += amount;
        }
    }

    public void addLife(int amount) {
        width += amount;
        System.out.println("ORIGINAL Width : " + originalWidth);
        System.out.println("Width : " + width);
        if (width < originalWidth) {
            roundedRectangle.setRoundRect(MARGIN, MARGIN, width, height,
                                            MARGIN, MARGIN);
            repaint();
        } else {
            width -= amount;
        }
    }
}