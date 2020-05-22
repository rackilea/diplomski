import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.*;
import javax.swing.*;

public class GridExample {
    private static void createAndShowGui() {
        final GridPanel gridPanel = new GridPanel();

        JButton resetBtn = new JButton(new AbstractAction("Reset") {

            @Override
            public void actionPerformed(ActionEvent e) {
                gridPanel.reset();
            }
        });
        JPanel btnPanel = new JPanel();
        btnPanel.add(resetBtn);

        JFrame frame = new JFrame("GridExample");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(gridPanel);
        frame.getContentPane().add(btnPanel, BorderLayout.PAGE_END);
        frame.pack();
        frame.setLocationRelativeTo(null);
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

@SuppressWarnings("serial")
class GridPanel extends JPanel {
    private static final int ROWS = 10;
    private static final int CELL_WIDTH = 28;
    private static final int PAD = 20;
    private static final int PREF_W = ROWS * CELL_WIDTH + 2 * PAD;
    private static final int PREF_H = PREF_W;
    private static final Color GRID_COLOR = Color.blue;
    private static final Color CIRCLE_COLOR = Color.red;
    private static final int SML_GAP = 2;
    private boolean[][] grid = new boolean[ROWS][ROWS];

    public GridPanel() {
        addMouseListener(new MyMouse());
    }

    @Override
    public Dimension getPreferredSize() {
        if (isPreferredSizeSet()) {
            return super.getPreferredSize();
        }
        return new Dimension(PREF_W, PREF_H);
    }

    public void reset() {
        grid = new boolean[ROWS][ROWS]; // fills grid with false
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // draw grid:
        g2.setColor(GRID_COLOR);
        for (int i = 0; i <= ROWS; i++) {
            int x1 = PAD + i * CELL_WIDTH;
            int y1 = PAD;
            int x2 = x1;
            int y2 = PAD + CELL_WIDTH * ROWS;
            g2.drawLine(x1, y1, x2, y2);
            g2.drawLine(y1, x1, y2, x2);
        }

        // iterate through the grid boolean array
        // draw red circles if the grid value is true.
        g2.setColor(CIRCLE_COLOR);
        int w = CELL_WIDTH - 2 * SML_GAP; // width of the circle to draw
        int h = w;
        // nested for loop to go through the grid array
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                if (grid[r][c]) {
                    int x = PAD + c * CELL_WIDTH + SML_GAP;
                    int y = PAD + r * CELL_WIDTH + SML_GAP;
                    g2.fillOval(x, y, w, h);
                }
            }
        }        
    }

    private class MyMouse extends MouseAdapter {
        public void mousePressed(MouseEvent e) {
            int x = e.getPoint().x;
            int y = e.getPoint().y;

            if (x < PAD || y < PAD) {
                // clicked above or to right of grid
                return;
            }

            int r = (y - PAD) / CELL_WIDTH;
            int c = (x - PAD) / CELL_WIDTH;

            // if clicked to right or below grid.
            // the < 0 part is likely unnecessary, but why not be extra safe?
            if (r >= ROWS || c >= ROWS || r < 0 || c < 0) {
                return;
            }
            grid[r][c] = true;
            repaint();
        }
    }
}