import java.awt.*;
import javax.swing.*;

public class LabelBackGround {

    private JFrame frame;

    public LabelBackGround() {
        JLabel lblWest = new JLabel();
        lblWest.setPreferredSize(new Dimension(50, 150));
        lblWest.setOpaque(true);
        lblWest.setBackground(Color.red);
        JLabel lblEast = new JLabel();
        lblEast.setPreferredSize(new Dimension(50, 150));
        lblEast.setOpaque(true);
        lblEast.setBackground(Color.red);
        frame = new JFrame();
        frame.add(new CustomColoredComponents(), BorderLayout.NORTH);
        frame.add(new CustomColoredComponents(), BorderLayout.SOUTH);
        frame.add(lblWest, BorderLayout.WEST);
        frame.add(lblEast, BorderLayout.EAST);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(100, 100);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                LabelBackGround gridBadFrame = new LabelBackGround();
            }
        });
    }
}

class CustomColoredComponents extends JLabel {

    private static final long serialVersionUID = 1L;

    @Override
    public Dimension getMinimumSize() {
        return new Dimension(200, 20);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(200, 30);
    }

    @Override
    public void paintComponent(Graphics g) {
        int margin = 10;
        Dimension dim = getSize();
        super.paintComponent(g);
        g.setColor(Color.blue);
        g.fillRect(margin, margin, dim.width - margin * 2, dim.height - margin * 2);
    }
}