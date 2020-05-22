import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class GameOfLife extends JPanel {

    private final int row, col;
    private boolean isLiving;

    public static Random random = new Random();

    public GameOfLife(int r, int c) {
        this.row = r;
        this.col = c;
        MouseListener listener = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                isLiving = !isLiving;
                repaint();
            }
        };
        this.addMouseListener(listener);
        isLiving = random.nextBoolean();
    }

    public boolean isAlive(int neighbors) {
        boolean alive = false;
        if (this.isLiving) {
            if (neighbors < 2) {
                alive = false;
            } else if (neighbors == 2 || neighbors == 3) {
                alive = true;
            } else if (neighbors > 3) {
                alive = false;
            }
        } else {
            if (neighbors == 3) {
                alive = true;
            }
        }
        return alive;
    }

    public void setAlive(boolean alive) {
        isLiving = alive;
    }

    public boolean isLiving() {
        return this.isLiving;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (this.isLiving) {
            g.fillRect(0, 0, getWidth() - 1, getHeight() - 1);
        } else {
            g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
        }
    }

    public static void main(String[] args) {
        final int s = 40;
        final GameOfLife[][] biosphere = new GameOfLife[s][s];
        final JPanel gui = new JPanel(new GridLayout(s, s, 2, 2));
        for (int ii = 0; ii < s; ii++) {
            for (int jj = 0; jj < s; jj++) {
                GameOfLife cell = new GameOfLife(ii, jj);
                cell.setPreferredSize(new Dimension(10, 10));
                gui.add(cell);
                biosphere[ii][jj] = cell;
            }
        }

        ActionListener al = (ActionEvent ae) -> {
            boolean[][] living = new boolean[s][s];
            for (int ii = 0; ii < s; ii++) {
                for (int jj = 0; jj < s; jj++) {
                    int top = (jj > 0 ? jj - 1 : s - 1);
                    int btm = (jj < s - 1 ? jj + 1 : 0);
                    int lft = (ii > 0 ? ii - 1 : s - 1);
                    int rgt = (ii < s - 1 ? ii + 1 : 0);
                    int neighbors = 0;
                    if (biosphere[ii][top].isLiving()) {
                        neighbors++;
                    }
                    if (biosphere[ii][btm].isLiving()) {
                        neighbors++;
                    }
                    if (biosphere[lft][top].isLiving()) {
                        neighbors++;
                    }
                    if (biosphere[lft][btm].isLiving()) {
                        neighbors++;
                    }
                    if (biosphere[lft][jj].isLiving()) {
                        neighbors++;
                    }
                    if (biosphere[rgt][jj].isLiving()) {
                        neighbors++;
                    }
                    if (biosphere[rgt][top].isLiving()) {
                        neighbors++;
                    }
                    if (biosphere[rgt][btm].isLiving()) {
                        neighbors++;
                    }
                    living[ii][jj] = biosphere[ii][jj].isAlive(neighbors);
                }
            }
            for (int ii = 0; ii < s; ii++) {
                for (int jj = 0; jj < s; jj++) {
                    biosphere[ii][jj].setAlive(living[ii][jj]);
                }
            }
            gui.repaint();
        };

        Timer timer = new Timer(50, al);
        timer.start();

        JOptionPane.showMessageDialog(null, gui);
        timer.stop();
    }
}