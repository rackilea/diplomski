import java.awt.GridLayout;

import javax.swing.*;

public class GridLayoutEg extends JPanel {
    private static final int ROWS = 3;
    private static final int COLS = 10;

    public GridLayoutEg() {
        setLayout(new GridLayout(ROWS, COLS)); // set JPanel's layout
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                String text = String.format("[%d, %d]", j + 1, i + 1);
                add(new JButton(text)); // add component w/o 2nd parameter
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }

    private static void createAndShowGui() {
        GridLayoutEg mainPanel = new GridLayoutEg();
        JFrame frame = new JFrame("GridLayoutEg");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(mainPanel);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }
}