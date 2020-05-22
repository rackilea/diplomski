import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class GBLayout extends JPanel {

    public GBLayout() {
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWeights = new double[] {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        setLayout(gridBagLayout);
        for (int y=0; y<10; ++y) {
            int offset = y & 1;
            if (offset != 0) {
                GridBagConstraints c = new GridBagConstraints(
                        0, y, // x, y
                        1, 1, // w, h
                        0D, 0D,
                        GridBagConstraints.NORTHWEST, GridBagConstraints.HORIZONTAL,
                        new Insets(2, 2, 2, 2),
                        0, 0);
                add(new JLabel("!"), c);
            }
            for (int x=0; x<10; ++x) {
                int bx = x * 2 + offset;
                int by = y;
                JButton b = new JButton("(" + bx + ", " + by + ")");
                GridBagConstraints c = new GridBagConstraints(
                        bx, by, // x, y
                        2, 1, // w, h
                        1D, 1D,
                        GridBagConstraints.NORTHWEST, GridBagConstraints.HORIZONTAL,
                        new Insets(2, 2, 2, 2),
                        0, 0);
                add(b, c);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                GBLayout panel = new GBLayout();
                JFrame frame = new JFrame("Test");
                frame.setLayout(new BorderLayout());
                frame.add(panel, BorderLayout.CENTER);
                frame.pack();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}