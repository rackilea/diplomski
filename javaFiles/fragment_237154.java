import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.*;

public class Mcve extends JPanel {
    private static final int TIMER_DELAY = 1000;
    private static final String IRON_FORMAT = "%03d iron";
    private int ironCount = 0;

    public Mcve() {
        setPreferredSize(new Dimension(400, 300));
        new Timer(TIMER_DELAY, e -> {
            ironCount++;
            repaint();
        }).start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawString(String.format(IRON_FORMAT, ironCount), 25, 45);
    }

    private static void createAndShowGui() {
        JFrame frame = new JFrame("Mcve");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new Mcve());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}