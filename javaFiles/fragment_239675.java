import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.*;

public class ChessBoardGUI extends JFrame {
    private static final long serialVersionUID = 1L;

    // !! code changes below only to allow me to run your code without
    // your images. !!
    // ImageIcon queenP = new ImageIcon(getClass().getResource("/images/queen.png"));
    // Image img = queenP.getImage();
    // Image newImg = img.getScaledInstance(40, 40,
    // java.awt.Image.SCALE_SMOOTH);
    private ImageIcon queenPic = createQueenIcon(); //!! delete this

    // all fields should be private and non-static
    private JButton tip;
    private JButton safe;
    private JLabel ifNotSafe;
    private JButton[][] chessBoxes = new JButton[8][8];
    private JPanel chessBoard;
    private ArrayList<Boxes> queensOnBoard = new ArrayList<Boxes>();

    public ChessBoardGUI() {
        createBoard();

        add(chessBoard, BorderLayout.CENTER); // Do this here

        // !! createOtherThings(); // get rid of -- put in constructor
        safe = new JButton("Safe?");
        tip = new JButton("Tip");
        ifNotSafe = new JLabel("Status of Board is displayed here...");

        ButtonListen1 safeListener = new ButtonListen1();
        ButtonListen2 tipListener = new ButtonListen2();

        safe.addActionListener(safeListener);
        tip.addActionListener(tipListener);

        // !! add the panel1 here!
        JPanel panel1 = new JPanel();
        panel1.add(ifNotSafe);
        panel1.add(safe);
        panel1.add(tip);
        add(panel1, BorderLayout.PAGE_START); // using BorderLayout constants

        // !! setSize(500, 500);

    }

    // !! so I can use images without having an image
    // !! you won't need this
    private Icon createQueenIcon() {
        int w = 40;
        BufferedImage img2 = new BufferedImage(w, w, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = img2.createGraphics();
        g2.setColor(new Color(183, 65, 14));
        g2.fillRect(0, 0, w, w);
        g2.setColor(new Color(255, 215, 0));
        Font font = new Font(Font.SANS_SERIF, Font.BOLD, 30);
        g2.setFont(font);
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        FontMetrics fontMetrics = g2.getFontMetrics();
        int textX = (w - fontMetrics.charWidth('Q')) / 2;
        int textY = (w - fontMetrics.getHeight()) / 2 + fontMetrics.getAscent();
        g2.drawString("Q", textX, textY);
        g2.dispose();
        return new ImageIcon(img2);
    }

    class ButtonListen1 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (checkSolution(queensOnBoard) == true) {
                // ****THIS IS WHERE THE PROBLEM IS ******* !!
                ifNotSafe.setText("This Solution is correct so far");
                System.out.println("Solution is correct");

            } else {
                ifNotSafe.setText("This Solution is incorrect so far");
                // *********Also highlight the queens that are not safe******
                System.out.println("Solution is incorrect");
            }
        }

    }

    /*
     * ActionListener for the tip button
     */
    class ButtonListen2 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
        }
    }

    /*
     * Creates the overall ChessBoard
     */
    public void createBoard() {
        GridLayout gridLayout = new GridLayout();
        gridLayout.setRows(8);
        gridLayout.setColumns(8);
        chessBoard = new JPanel(gridLayout);
        chessBoard.setPreferredSize(new Dimension(640, 640));
        chessBoard.setBorder(new LineBorder(Color.BLACK));
        chessBoard.setVisible(true);

        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                chessBoxes[x][y] = new JButton();
                chessBoxes[x][y].setBorderPainted(false);
                if ((x + y) % 2 == 0) {
                    chessBoxes[x][y].setBackground(Color.BLACK);
                } else {
                    chessBoxes[x][y].setBackground(Color.WHITE);
                }
                chessBoxes[x][y].setOpaque(true);
                chessBoard.add(chessBoxes[x][y]);

                BoxListener boxListen = new BoxListener();
                chessBoxes[x][y].addActionListener(boxListen);
            }
        }
    }

    class BoxListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton button = ((JButton) e.getSource());

            for (int x = 0; x < 8; x++) {
                for (int y = 0; y < 8; y++) {
                    if (chessBoxes[x][y] == button) {
                        if ((isOnBoard(queensOnBoard, x, y) == false)) {
                            if (queensOnBoard.size() < 8) {
                                button.setIcon(queenPic);
                                queensOnBoard.add(new Boxes(x, y));
                            }
                        }
                        /*
                         * If there is a Queen at that JButton
                         */
                        else {
                            removeQueen(queensOnBoard, x, y);
                            button.setIcon(null);
                        }
                    }
                }
            }
        }
    }

    /*
     * Checks if a certain Box has a Queen in it or not
     * 
     * @param a Is the ArrayList of the Boxes currently occupied by Queens
     * 
     * @param x Is the X coordinate of the Box that was clicked
     * 
     * @param y Is the Y coordinate of the Box that was clicked
     */
    public boolean isOnBoard(ArrayList<Boxes> a, int x, int y) {
        for (int i = 0; i < a.size(); i++) {
            if (((a.get(i)).getX() == x) && ((a.get(i)).getY() == y)) {
                return true;
            }
        }
        return false;
    }

    /*
     * Removes a Queen from the GUI at the specified Box (JButton)
     * 
     * @param a Is the ArrayList of the Boxes currently occupied by Queens
     * 
     * @param x Is the X coordinate of the Box that was clicked
     * 
     * @param y Is the Y coordinate of the Box that was clicked
     */
    public void removeQueen(ArrayList<Boxes> a, int x, int y) {
        /*
         * Removes the box from the overall ArrayList of Boxes Occupied by
         * queens according to the x and y location
         */
        for (int i = 0; i < a.size(); i++) {
            if (((a.get(i)).getX() == x) && ((a.get(i)).getY() == y)) {
                queensOnBoard.remove(i);
            }
        }
    }

    /*
     * Return to the user which queens need to be highlighted
     * 
     * @param queensOnBoard Is the ArrayList of Boxes that are occupied by
     * Queens currently on the ChessBoard
     */
    public void conflictingQueens(ArrayList<Boxes> queensOnBoard2) {

    }

    /*
     * Checks to see if solution is correct thusfar
     * 
     * @param queensOnBoard Is the ArrayList of Boxes that are occupied by
     * Queens currently on the ChessBoard
     */
    public boolean checkSolution(ArrayList<Boxes> queensOnBoard2) {
        int size = queensOnBoard2.size();
        if (size < 1) {
            return true;
        }
        if (size == 1) {
            return true;
        }
        for (int x = 0; x < size - 1; x++) {
            for (int y = 1; y < size; y++) {
                if (queensOnBoard2.get(x).getX() == queensOnBoard2.get(y).getX()) {
                    return false;
                } else if (queensOnBoard2.get(x).getY() == queensOnBoard2.get(y).getY()) {
                    return false;
                }
            }
        }

        return true;
    }

    /*
     * Checks to see if the queen is safe from diagonal attacks
     */

    /*
     * Highlights boxes that are conflicting with one another
     * 
     * @param highlight Is the ArrayList of Boxes that are occupied by Queens
     * currently on the ChessBoard
     */
    public void highlightBoxes(ArrayList<Boxes> highlight) {
        int size1 = highlight.size();
        int size2 = queensOnBoard.size();
        if ((size1 == 0) && size1 == 1) {
            for (int x = 0; x < 8; x++) {
                for (int y = 0; y < 8; y++) {
                    chessBoxes[x][y] = new JButton();
                    chessBoxes[x][y].setBorderPainted(false);
                    /*
                     * Assigns a color to every other box
                     */
                    if ((x + y) % 2 == 0) {
                        chessBoxes[x][y].setBackground(Color.BLACK);
                    } else {
                        chessBoxes[x][y].setBackground(Color.WHITE);
                    }
                }
            }
        }
        for (int b = 0; b < size2; b++) {
            for (int a = 0; a < size1; a++) {
                if ((highlight.get(a).getX() == queensOnBoard.get(b).getX())
                        && (highlight.get(a).getY() == queensOnBoard.get(b).getY())) {
                    int x = queensOnBoard.get(b).getX();
                    int y = queensOnBoard.get(b).getY();
                    chessBoxes[x][y].setBackground(Color.RED);
                }
            }
        }
    }

    public static void main(String[] args) {
        // !! create the GUI in a Swing thread-safe manner
        SwingUtilities.invokeLater(() -> createGui());
    }

    public static void createGui() {
        JFrame frame = new ChessBoardGUI();
        // !! frame.add(chessBoard); // not here
        // !! chessBoard.setLocation(50, 50);

        // !! this does not belong within main
        // !! JPanel panel1 = new JPanel();
        // panel1.add(ifNotSafe);
        // panel1.add(safe);
        // panel1.add(tip);
        // frame.add(panel1);

        frame.setTitle("ChessBoard");
        frame.pack(); // !! call this to have your GUI size itself
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private static class Boxes {

        private int x;
        private int y;

        public Boxes(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getY() {
            return x;
        }

        public int getX() {
            return y;
        }

    }
}