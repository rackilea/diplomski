import java.awt.*;
import java.awt.Graphics;
import java.util.*;
import javax.swing.*;

public class NewGrid {

    private int row = 10;
    private int column = 10;
    private JFrame frame = new JFrame();
    private JPanel panel = new JPanel();

    private NewGrid() {
        addboxes();
        panel.setLayout(new GridLayout(row, column));
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void addboxes() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                Boxes box = new Boxes();
                box.putClientProperty("row", row);
                box.putClientProperty("column", column);
                panel.add(box);
            }
        }
    }

    public static void main(String[] args) {
        Runnable doRun = new Runnable() {
            @Override
            public void run() {
                new NewGrid();
            }
        };
        SwingUtilities.invokeLater(doRun);
    }
}

class Boxes extends JPanel {

    private static final long serialVersionUID = 1L;

    @Override
    public Dimension getMinimumSize() {
        return new Dimension(20, 20);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(20, 20);
    }

    @Override
    public Dimension getMaximumSize() {
        return new Dimension(20, 20);
    }

    @Override
    public void paintComponent(Graphics g) {
        int margin = 2;
        Dimension dim = getSize();
        super.paintComponent(g);
        g.setColor(Color.red);
        g.fillRect(margin, margin, dim.width - margin * 2, 
           dim.height - margin * 2);
    }
}