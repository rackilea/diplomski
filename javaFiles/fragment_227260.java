import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

@SuppressWarnings("serial")
public class ManyFields extends JPanel {

    private static final int ROWS = 10;
    private static final int COLS = ROWS;
    private static final int GAP = 2;
    private static final int TF_COLS = 5;
    public static final String ROW = "row";
    public static final String COL = "col";
    private JTextField[][] fieldGrid = new JTextField[ROWS][COLS];

    public ManyFields() {
        setLayout(new GridLayout(ROWS, COLS, GAP, GAP));
        setBorder(BorderFactory.createEmptyBorder(GAP, GAP, GAP, GAP));

        TFieldListener tFieldListener = new TFieldListener();

        for (int row = 0; row < fieldGrid.length; row++) {
            for (int col = 0; col < fieldGrid[row].length; col++) {
                JTextField tField = new JTextField(TF_COLS);
                tField.putClientProperty(ROW, row);
                tField.putClientProperty(COL, col);
                tField.addActionListener(tFieldListener);

                add(tField);
                fieldGrid[row][col] = tField;
            }
        }
    }

    private class TFieldListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JTextField field = (JTextField) e.getSource();
            int row = (int) field.getClientProperty(ROW);
            int col = (int) field.getClientProperty(COL);

            // or another way to get row and column using the array:
            int row2 = -1;
            int col2 = -1;
            for (int r = 0; r < fieldGrid.length; r++) {
                for (int c = 0; c < fieldGrid[r].length; c++) {
                    if (field == fieldGrid[r][c]) {
                        row2 = r;
                        col2 = c;
                    }
                }
            }
            // now here row2 and col2 are set

            String text = field.getText();

            String title = String.format("Text for Cell [%d, %d]", col, row);
            String message = "text: " + text;
            int messageType = JOptionPane.INFORMATION_MESSAGE;
            JOptionPane.showMessageDialog(ManyFields.this, message, title, messageType);
            field.transferFocus(); // move to next component
        }
    }

    private static void createAndShowGui() {
        ManyFields mainPanel = new ManyFields();

        JFrame frame = new JFrame("Many Fields");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}