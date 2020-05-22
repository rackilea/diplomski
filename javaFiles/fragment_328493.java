import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

@SuppressWarnings("serial")
public class SimpleCellGrid extends JPanel {
    private static final int ROWS = 40;
    private static final int COLS = 40;
    private static final int CELL_WIDTH = 10;
    private static final int PREF_W = CELL_WIDTH * COLS;
    private static final int PREF_H = CELL_WIDTH * ROWS;
    private SimpleCell[][] cellGrid = new SimpleCell[ROWS][COLS];

    public SimpleCellGrid() {
        MyMouse myMouse = new MyMouse();
        addMouseListener(myMouse);
        for (int row = 0; row < cellGrid.length; row++) {
            for (int col = 0; col < cellGrid[row].length; col++) {
                int x = col * CELL_WIDTH;
                int y = row * CELL_WIDTH;
                cellGrid[row][col] = new SimpleCell(x, y, CELL_WIDTH);
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        for (SimpleCell[] cellRow : cellGrid) {
            for (SimpleCell simpleCell : cellRow) {
                simpleCell.draw(g2);
            }
        }
    }

    @Override
    public Dimension getPreferredSize() {
        if (isPreferredSizeSet()) {
            return super.getPreferredSize();
        }
        return new Dimension(PREF_W, PREF_H);
    }

    private class MyMouse extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
            for (SimpleCell[] cellRow : cellGrid) {
                for (SimpleCell simpleCell : cellRow) {
                    if (simpleCell.contains(e.getPoint())) {
                        simpleCell.setAlive(!simpleCell.isAlive());
                    }
                }
            }
            repaint();
        }
    }

    private static void createAndShowGui() {
        JFrame frame = new JFrame("SimpleCellGrid");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new SimpleCellGrid());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}