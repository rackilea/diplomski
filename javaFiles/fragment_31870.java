import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DrawGrid {

    public DrawGrid() {
        int[][] grid = getGrid();

        JPanel panel = new JPanel(new GridLayout(10, 10));
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                panel.add(new JLabel(String.valueOf(grid[i][j])));
            }
        }

        JFrame frame = new JFrame();
        frame.add(panel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


    }

    public int[][] getGrid() {
        int[][] grid = new int[10][10];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = i;
            }
        }
        return grid;

    }
    public static void main(String[] args) {
        new DrawGrid();

    }

}