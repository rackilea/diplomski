import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class TicTacToePanel extends JPanel {
    private static final int ROWS = 3;
    private static final int MY_C = 240;
    private static final Color BG = new Color(MY_C, MY_C, MY_C);
    private static final int PTS = 60;
    private static final Font FONT = new Font(Font.SANS_SERIF, Font.BOLD, PTS);
    public static final Color X_COLOR = Color.BLUE;
    public static final Color O_COLOR = Color.RED;
    private JLabel[][] labels = new JLabel[ROWS][ROWS];
    private boolean xTurn = true;

    public TicTacToePanel() {
        setLayout(new GridLayout(ROWS, ROWS, 2, 2));
        setBackground(Color.black);

        MyMouse myMouse = new MyMouse();
        for (int row = 0; row < labels.length; row++) {
            for (int col = 0; col < labels[row].length; col++) {
                JLabel label = new JLabel("     ", SwingConstants.CENTER);
                label.setOpaque(true);
                label.setBackground(BG);
                label.setFont(FONT);
                add(label);
                label.addMouseListener(myMouse);
            }
        }
    }

    private class MyMouse extends MouseAdapter {
        @Override // override mousePressed not mouseClicked
        public void mousePressed(MouseEvent e) {
            JLabel label = (JLabel) e.getSource();
            String text = label.getText().trim();
            if (!text.isEmpty()) {
                return;
            }
            if (xTurn) {
                label.setForeground(X_COLOR);
                label.setText("X");
            } else {
                label.setForeground(O_COLOR);
                label.setText("O");
            }

            // information to help check for win
            int chosenX = -1;
            int chosenY = -1;
            for (int x = 0; x < labels.length; x++) {
                for (int y = 0; y < labels[x].length; y++) {
                    if (labels[x][y] == label) {
                        chosenX = x;
                        chosenY = y;
                    }
                }
            }
            // TODO: check for win here
            xTurn = !xTurn;
        }
    }

    private static void createAndShowGui() {
        TicTacToePanel mainPanel = new TicTacToePanel();

        JFrame frame = new JFrame("Tic Tac Toe");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationByPlatform(true);
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