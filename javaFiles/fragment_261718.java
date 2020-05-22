import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

@SuppressWarnings("serial")
public class MousePosition extends JPanel {
    private static final int PREF_W = 600;
    private static final int PREF_H = PREF_W;
    // format String for display String
    protected static final String FORMAT = "(%d, %d)";
    private int xPos = -40;
    private int yPos = -40;
    private String displayText = "";

    public MousePosition() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                xPos = e.getX();
                yPos = e.getY();
                // use FORMAT String to create our display text
                displayText = String.format(FORMAT, xPos, yPos);
                repaint();
            }
        });
    }

    @Override
    public Dimension getPreferredSize() {
        if (isPreferredSizeSet()) {
            return super.getPreferredSize();
        }
        return new Dimension(PREF_W, PREF_H);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawString(displayText, xPos, yPos);

    }

    private static void createAndShowGui() {
        MousePosition mainPanel = new MousePosition();

        JFrame frame = new JFrame("MousePosition");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationByPlatform(true);
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