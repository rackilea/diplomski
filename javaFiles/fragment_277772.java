import java.awt.*;
import javax.swing.*;

public class CenteredPanel {

    public static void main(String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                JPanel gui = new JPanel(new GridBagLayout());
                JPanel square = new SquarePanel();
                square.setBackground(Color.RED);
                gui.add(square);

                JFrame f = new JFrame("SquareBoard");
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                f.setLocationByPlatform(true);
                f.add(gui);
                f.setMinimumSize(new Dimension(400,100));
                f.pack();
                f.setVisible(true);
            }
        };
        SwingUtilities.invokeLater(r);
    }
}

class SquarePanel extends JPanel {
    @Override
    public Dimension getPreferredSize() {
        Container c = this.getParent();
        int size = Math.min(c.getHeight(), c.getWidth());
        Dimension d = new Dimension(size,size);
        return d;
    }
}