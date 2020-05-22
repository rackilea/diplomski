import java.awt.GridLayout;
import java.awt.event.*;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class PlayField {
    private static final int ROWS = 8;
    private static final int COLS = ROWS;
    private static final int MAX_RAND = 80;
    private JPanel mainPanel = new JPanel();
    private MatrixButton[][] button = new MatrixButton[ROWS][COLS];

    public PlayField(){
        Random rand = new Random();
        mainPanel.setLayout(new GridLayout(ROWS, COLS));
        for (int i = 0; i < ROWS; ++i){
            for (int j = 0; j < COLS; ++j){
                button[i][j] = new MatrixButton(j, i, rand.nextInt(MAX_RAND));
                button[i][j].addActionListener(new MyMatrixListener(i, j));
                mainPanel.add(button[i][j].getButton());
            }
        }
    }

    private class MyMatrixListener implements ActionListener {
        private int i;
        private int j;

        public MyMatrixListener(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            for (int i2 = 0; i2 < button.length; i2++) {
                if (i2 != i) {
                    int value = button[i2][j].getValue();
                    value++;
                    button[i2][j].setValue(value);
                }
            }
            for (int j2 = 0; j2 < button[i].length; j2++) {
                if (j2 != j) {
                    int value = button[i][j2].getValue();
                    value++;
                    button[i][j2].setValue(value);
                }
            }
        }
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    private static void createAndShowGui() {
        JFrame
        frame = new JFrame("PlayField");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new PlayField().getMainPanel());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }    
}