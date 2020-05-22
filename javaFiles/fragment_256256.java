import java.awt.*;
import javax.swing.*;

public class SwingPaintDemo2 extends JPanel {

    public static boolean isWall = true;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI() {
        //System.out.println("Created GUI on EDT? "+
        //SwingUtilities.isEventDispatchThread());
        JFrame f = new JFrame("Swing Paint Demo");
        JPanel MyPanel = new JPanel();
        MyPanel.setBorder(BorderFactory.createEmptyBorder(1000, 1000, 1000, 1000));
        MyPanel.setPreferredSize(new Dimension(250, 200));
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(new SwingPaintDemo2());
        f.pack();
        f.setVisible(true);

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int l = 10;
        int w = 10;

        g.setColor(Color.black);
        g.fillRect(l, w, 100, 100);

    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(150, 150);
    }
}