import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

@SuppressWarnings("serial")
public class SimpleChess extends JPanel {
    private ChessBoard chessBoard = new ChessBoard();
    private JTextField rankField = new JTextField(3);
    private JTextField fileField = new JTextField(3);

    public SimpleChess() {
        MyMouse myMouse = new MyMouse();
        chessBoard.addMouseListener(myMouse);

        rankField.setHorizontalAlignment(SwingConstants.CENTER);
        rankField.setFocusable(false);
        fileField.setHorizontalAlignment(SwingConstants.CENTER);
        fileField.setFocusable(false);
        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("Rank:"));
        topPanel.add(rankField);
        topPanel.add(Box.createHorizontalStrut(40));
        topPanel.add(new JLabel("File:"));
        topPanel.add(fileField);

        setLayout(new BorderLayout());
        add(topPanel, BorderLayout.PAGE_START);
        add(chessBoard, BorderLayout.CENTER);
    }

    class MyMouse extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
            if (e.getButton() != MouseEvent.BUTTON1) {
                return;
            }
            Component c = chessBoard.getComponentAt(e.getPoint());
            if (!(c instanceof JLabel)) {
                return;
            }
            JLabel cell = (JLabel) c;
            String rank = (String) cell.getClientProperty(ChessBoard.RANK);
            String file = (String) cell.getClientProperty(ChessBoard.FILE);
            // icon = cell.getIcon();
            rankField.setText(rank);
            fileField.setText(file);
        }
    }

    private static void createAndShowGui() {
        JFrame frame = new JFrame("Chess");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new SimpleChess());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}

@SuppressWarnings("serial")
class ChessBoard extends JPanel {
    public static final String RANK = "rank";
    public static final String FILE = "file";
    private static final int ROWS = 8;
    private static final int COLS = 8;
    private static final Color COLOR_LIGHT = new Color(240, 201, 175);
    private static final Color COLOR_DARK = new Color(205, 133, 63);
    private static final Dimension CELL_SIZE = new Dimension(60, 60);
    private JLabel[][] chessTable = new JLabel[ROWS][COLS];

    public ChessBoard() {
        // create chess table
        setLayout(new GridLayout(ROWS, COLS));
        for (int i = 0; i < chessTable.length; i++) {
            for (int j = 0; j < chessTable[i].length; j++) {
                String rank = String.valueOf((char) ('8' - i));
                String file = String.valueOf((char) ('a' + j));
                JLabel label = new JLabel();
                label.setPreferredSize(CELL_SIZE);
                label.setOpaque(true);
                Color c = i % 2 == j % 2 ? COLOR_LIGHT : COLOR_DARK;
                label.setBackground(c);
                label.putClientProperty(RANK, rank);
                label.putClientProperty(FILE, file);
                chessTable[i][j] = label;
                add(label);
            }
        }
    }
}