import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.*;

@SuppressWarnings("serial")
public class GridWithBorders extends JPanel {
    private static final int SIDES = 6;
    private static final int SIDE_LENGTH = 60;
    private static final int GAP = 3;
    private static final Color BG = Color.BLACK;
    private static final Color CELL_COLOR = Color.GREEN.darker();

    public GridWithBorders() {
        setBackground(BG);
        setBorder(BorderFactory.createEmptyBorder(GAP, GAP, GAP, GAP));
        setLayout(new GridLayout(SIDES, SIDES, GAP, GAP));
        Dimension prefSize = new Dimension(SIDE_LENGTH, SIDE_LENGTH);
        for (int i = 0; i < SIDES; i++) {
            for (int j = 0; j < SIDES; j++) {
                JPanel cell = new JPanel();
                cell.setBackground(CELL_COLOR);
                cell.setPreferredSize(prefSize);
                add(cell);
            }
        }
    }

    private static void createAndShowGui() {
        GridWithBorders mainPanel = new GridWithBorders();

        JFrame frame = new JFrame("GridWithBorders");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}