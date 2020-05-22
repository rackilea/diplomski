import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MineSweeper {

    public static void main(String[] args) {
        MainFrame window = new MainFrame();
        window.setVisible(true);
    }
}

/**
 * Main frame. Initialize window and adds panel with buttons and clear button on
 * the window.
 * */
class MainFrame extends JFrame {

    private static final long serialVersionUID = 1L;

    private final Board board = new Board(10, 11);

    public MainFrame() {
        setLocation(400, 400);
        setLayout(new GridLayout(2, 1));
        add(board);
        add(createClearButton());
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private JButton createClearButton() {
        JButton button = new JButton();
        button.setText("Clear");
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                board.clear();
            }
        });
        return button;
    }
}

/***
 * This class contains all buttons on one panel. We initialize all buttons in
 * constructor. We can use {@link Board#clear()} method for reveal all buttons.
 * */
class Board extends JPanel {

    private static final long serialVersionUID = 1L;

    private JButton[][] plate;
    private int numberOfRows;
    private int numberOfColumns;

    public Board(int numberOfRows, int numberOfColumns) {
        this.numberOfRows = numberOfRows;
        this.numberOfColumns = numberOfColumns;
        this.plate = new JButton[numberOfColumns][numberOfRows];
        setLayout(new GridLayout(numberOfRows, numberOfColumns));
        init();
    }

    private void init() {
        for (int x = 0; x < numberOfColumns; x++) {
            for (int y = 0; y < numberOfRows; y++) {
                JButton button = createNewJButton(x, y);
                plate[x][y] = button;
                add(button);
            }
        }
    }

    private JButton createNewJButton(int x, int y) {
        JButton button = new JButton();
        button.setText(x + ", " + y);
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JButton button = (JButton) e.getSource();
                button.setText("X");
            }
        });
        return button;
    }

    public void clear() {
        for (int x = 0; x < numberOfColumns; x++) {
            for (int y = 0; y < numberOfRows; y++) {
                plate[x][y].setText(x + ", " + y);
            }
        }
    }
}