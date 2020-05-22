import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;
import javax.swing.*;

public class CustomPainting {

    private RectangleComponent lifeDeath;

    private void createAndDisplayGUI() {
        JFrame frame = new JFrame("Custom Painting");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(0, 2, 5, 5));
        // Specifying the WIDTH, HEIGHT and Colour for this JComponent.
        lifeDeath = new RectangleComponent(Color.GREEN, Color.RED, 20, 20);
        centerPanel.add(lifeDeath);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 2, 5, 5));
        JButton incLifeButton = new JButton("INCREASE LIFE");
        incLifeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                lifeDeath.addLife(1);
            }
        });

        JButton decLifeButton = new JButton("DECREASE LIFE");
        decLifeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                lifeDeath.subtractLife(1);
            }
        });

        buttonPanel.add(incLifeButton);
        buttonPanel.add(decLifeButton);

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

    private Color lifeColour;
    private Color deathColour;
    private static final int MARGIN = 10;
    private int widthLife;
    private int widthDeath;
    private int height;
    private int originalWidth;
    private RoundRectangle2D roundedRectangle;

    public RectangleComponent(Color lc, Color dc, int w, int h) {
        lifeColour = lc;
        deathColour = dc;
        widthLife = w;
        height = h;
        originalWidth = widthLife;
        widthDeath = 0;     
    }

    /*
     * Overriding this method, so that
     * the size of the JComponent
     * can be determined, on the screen
     * or by the LayoutManager concern.
     */
    @Override 
    public Dimension getPreferredSize() {
        return (new Dimension(originalWidth, height));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        roundedRectangle = new RoundRectangle2D.Float((MARGIN + widthDeath), MARGIN,
                                        widthLife, height, MARGIN, MARGIN);
        g2d.setPaint(lifeColour);
        g2d.draw(roundedRectangle);
        g2d.fill(roundedRectangle);

        roundedRectangle.setRoundRect(MARGIN, MARGIN,
                                        widthDeath, height, MARGIN, MARGIN);
        g2d.setPaint(deathColour);
        g2d.draw(roundedRectangle);
        g2d.fill(roundedRectangle);
    }

    public void subtractLife(int amount) {
        widthLife -= amount;
        widthDeath += amount;
        System.out.println("ORIGINAL Width : " + originalWidth);
        System.out.println("Width Life : " + widthLife);
        System.out.println("Width Death : " + widthDeath);
        if (widthLife > 0 && widthDeath < originalWidth) {
            /*
             * This repaint() will call the paintComponent(...)
             * by itself, so nothing else to be done.
             */
            repaint();
        } else {
            widthLife += amount;
            widthDeath -= amount;
        }
    }

    public void addLife(int amount) {
        widthLife += amount;
        widthDeath -= amount;
        System.out.println("ORIGINAL Width : " + originalWidth);
        System.out.println("Width Life : " + widthLife);
        System.out.println("Width Death : " + widthDeath);
        if (widthLife < originalWidth && widthDeath > 0) {
            repaint();
        } else {
            widthLife -= amount;
            widthDeath += amount;
        }   
    }
}