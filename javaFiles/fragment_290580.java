import java.awt.*;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import javax.swing.*;

public class Grid extends Canvas {

    Cell[][] maze;
    int rows;
    int cols;
    int pathSize;
    double width, height;

    public Grid(int rows, int cols, int h, int w) {
        this.rows = rows;
        this.cols = cols;
        maze = new Cell[rows][cols];
        setPreferredSize(new Dimension(h, w));
    }

    public static void main(String[] args) {
        JFrame y = new JFrame();
        y.setLayout(new BorderLayout());
        Grid f = new Grid(40, 25, 400, 400);
        y.add(f, BorderLayout.CENTER);
        y.setSize(450, 450);
        y.setVisible(true);

    }

    public void paint(Graphics g) {
        int k, j, z = 0;
        width = getSize().width;
        height = getSize().height;

        double htOfRow = height / (rows);
        double wdOfRow = width / (cols);

        for (j = 0; j < rows; j++) {
            for (k = 0; k < cols; k++) {
                g.drawLine((int) (k * wdOfRow), (int) (j * htOfRow), (int) (k * wdOfRow), (int) ((j+1) * htOfRow));
            }
        }
        for (j = 0; j < rows; j++) {
            for (k = 0; k < cols; k++) {
                g.drawLine((int) (k * wdOfRow), (int) (j * htOfRow), (int) ((k+1) * wdOfRow), (int) (j * htOfRow));
            }
        }
    }

    class Cell {
    }
}