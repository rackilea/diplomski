import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class TicTacToeGUI implements ActionListener {
    private JFrame frame;
    private JButton[][] board;
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem newGame;
    private JMenuItem quit;
    private Arbiter arbiter;


    public TicTacToeGUI() {
        super();
        this.arbiter = new Arbiter();
        initializeMenuBar();
        initializeBoard();
    }

    public void initializeBoard() {
        frame = new JFrame();
        frame.setTitle("Tic Tac Toe v0.1");
        frame.setBounds(100, 100, 600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout(0, 0));
        frame.setResizable(false);
        //Creating MENU
        frame.setJMenuBar(menuBar);
        frame.setVisible(true);

        JPanel panel = new JPanel();
        panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(new GridLayout(3, 3, 2, 2));

        //Add a JButton[3][3] array and actionListener
        board = new JButton[3][3];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = new JButton("");
                panel.add(board[i][j]);
                board[i][j].addActionListener(this);
            }
        }
        refreshBoardValues();
    }

    public void initializeMenuBar() {
        //Create menu Bar
        menuBar = new JMenuBar();

        menu = new JMenu("MENU");
        menuBar.add(menu);

        newGame = new JMenuItem("New Game");
        menu.add(newGame);

        quit = new JMenuItem("Quit");
        menu.add(quit);
        //Add functionality to newGame menu item.
        newGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                arbiter.setGame();
            }
        });
        //Add functionality to quit menu item.
        quit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(board[i][j] == (JButton) e.getSource()) {
                    arbiter.setText(i, j);
                    refereshBoardValue(i, j);
                    if(arbiter.hasWinner()) {
                        winner();
                    }
                    return;
                }
            }
        }
    }

    private void refreshBoardValues() {
        String[][] currentValues = arbiter.getBoardValues();
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                board[i][j].setText(currentValues[i][j]);
            }
        }
    }

    private void refereshBoardValue(int x, int y) {
        board[x][y].setText(arbiter.getBoardValue(x, y));
    }

    private void winner(){
        JOptionPane.showMessageDialog(frame,
                "Mamy zwycięzcę!!!",
                "A winner is:",
                JOptionPane.PLAIN_MESSAGE);
    }
}