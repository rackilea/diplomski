import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;    
import javax.swing.*;

public class TicTacFoo extends JPanel {
    private static final long serialVersionUID = 1L;
    private static final int ROWS = 3;
    private static final Font BTN_FONT = new Font(Font.SANS_SERIF, Font.BOLD, 80);
    private JButton[][] buttons = new JButton[ROWS][ROWS];
    private boolean xTurn = true;
    private int count = 0;

    public TicTacFoo() {

        JPanel buttonPanel = new JPanel(new GridLayout(ROWS, ROWS));
        setLayout(new GridLayout(ROWS, ROWS));

        // single ActionListener for all buttons
        ButtonListener buttonListener = new ButtonListener();

        // create buttons in nested for loop
        for (int row = 0; row < buttons.length; row++) {
            for (int col = 0; col < buttons[row].length; col++) {
                buttons[row][col] = new JButton("   ");
                buttons[row][col].setFont(BTN_FONT);
                buttons[row][col].addActionListener(buttonListener);
                buttonPanel.add(buttons[row][col]);
            }
        }

        setLayout(new BorderLayout());
        add(buttonPanel);
        add(new JButton(new ResetAction()), BorderLayout.PAGE_END);
    }

    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            // get the button that was pressed
            JButton buttonPressed = (JButton) e.getSource();
            String text = buttonPressed.getText().trim();
            if (!text.isEmpty()) {
                // button already has been pressed
                // so exit from the listener
                return;
            }

            if (xTurn) {
                buttonPressed.setText("X");
            } else {
                buttonPressed.setText("O");
            }

            int rowPressed = -1;
            int colPressed = -1;
            // which button pressed?
            for (int row = 0; row < buttons.length; row++) {
                for (int col = 0; col < buttons[row].length; col++) {
                    if (buttons[row][col] == buttonPressed) {
                        rowPressed = row;
                        colPressed = col;
                        break;
                    }
                }
            }

            // TODO: here code where you would test for win
            // ......

            // swap turn
            xTurn = !xTurn;
            // increment count:
            count++;
            System.out.printf("count: %d, [row, col]: [%d, %d]%n", count, rowPressed, colPressed);
        }
    }

    // resets program back to initial state
    @SuppressWarnings("serial")
    class ResetAction extends AbstractAction {
        public ResetAction() {
            super("Reset");
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            // loop through all buttons, resetting state back to initial
            for (JButton[] buttonRow : buttons) {
                for (JButton button : buttonRow) {
                    button.setText("   ");
                }
            }
            xTurn = true;
            count = 0;
        }
    }

    private static void createAndShowGui() {
        TicTacFoo mainPanel = new TicTacFoo();

        JFrame frame = new JFrame("TicTacFoo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}