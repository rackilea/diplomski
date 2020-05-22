import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.LineBorder;

public class TicTacToe {

    Cell[][] cells = new Cell[3][3];
    boolean humanTurn = true;

    public TicTacToe() {

        JFrame frame = new JFrame("T I C - T A C - T O E");

        JPanel panel = new JPanel(new GridLayout(3, 3));
        addCells(panel);

        frame.add(panel);

        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        ActionListener actionListener = new ActionListener() {

            Random r = new Random();

            @Override
            public void actionPerformed(ActionEvent e) {

                if (!humanTurn) {
                    // Random cell
                    int x = r.nextInt(3);
                    int y = r.nextInt(3);
                    Cell cell = cells[x][y];

                    if (!cell.clicked) {

                        // Only the computer runs the gameloop, so false
                        cell.human = false;
                        cell.cross = false;

                        cell.repaint();

                        // Make sure the panel repaints before setting next
                        // booleans
                        EventQueue.invokeLater(new Runnable() {
                            public void run() {
                                humanTurn = true;
                                cell.clicked = true;
                            }
                        });
                    }
                }

            }
        };
        Timer gameloop = new Timer(10, actionListener);
        gameloop.start();

    }

    private void addCells(JPanel panel) {

        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {

                Cell cell = new Cell();
                cell.setBorder(new LineBorder(Color.BLACK));

                cells[x][y] = cell;

                panel.add(cell);

            }
        }
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TicTacToe();
            }
        });

    }

    class Cell extends JPanel implements MouseListener {

        boolean clicked = false;
        boolean human = true;
        boolean cross = false;

        public Cell() {

            addMouseListener(this);

        }

        @Override
        public void paintComponent(Graphics g) {

            super.paintComponent(g);

            Graphics2D gg = (Graphics2D) g;

            // Makes drawing smooth
            gg.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            // Drawing blue cross (player)
            if (human && cross) {
                gg.setColor(Color.BLUE);
                gg.drawLine(20, 20, getWidth() - 20, getHeight() - 20);
                gg.drawLine(getWidth() - 20, 20, 20, getHeight() - 20);
            }

            // Drawing red circle (computer)
            else if (!human && !cross) {
                gg.setColor(Color.RED);
                gg.drawOval(10, 10, getWidth() - 20, getHeight() - 20);
            }

        }

        @Override
        public void mouseClicked(MouseEvent arg0) {

            if (humanTurn && !clicked) {

                // Only human can click on the panel, so true
                human = true;
                cross = true;

                repaint();

                // Make sure the panel repaints before setting next booleans
                EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        humanTurn = false;
                        clicked = true;
                    }
                });

            }

        }

        @Override
        public void mouseEntered(MouseEvent arg0) {

        }

        @Override
        public void mouseExited(MouseEvent arg0) {

        }

        @Override
        public void mousePressed(MouseEvent arg0) {

        }

        @Override
        public void mouseReleased(MouseEvent arg0) {

        }

    }

}