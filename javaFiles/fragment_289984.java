import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class SudokuGrid {

    public static void main(String[] args) {
        new SudokuGrid();
    }

    public SudokuGrid() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public static class TestPane extends JPanel {

        private static final int ROWS = 9;
        private static final int COLUMNS = 9;
        int fontSize = 30;

        public TestPane() {
            JTextField[][] inputBoxes = new JTextField[ROWS][COLUMNS];
            Font font = new Font("Helvetica", Font.BOLD, fontSize);

            setLayout(new GridBagLayout());

            GridBagConstraints gbc = new GridBagConstraints();
            gbc.fill = GridBagConstraints.BOTH;
            gbc.weightx = 1;
            gbc.weighty = 1;
            gbc.gridy = 0;

            GridBagConstraints split = new GridBagConstraints();
            split.fill = GridBagConstraints.BOTH;
            split.weightx = 1;
            split.gridx = 0;
            split.gridwidth = GridBagConstraints.REMAINDER;

            // outer loop to create the rows
            for (int rows = 0; rows < ROWS; rows++) {

                gbc.gridy++;
                // inner loop to create the columns
                for (int columns = 0; columns < COLUMNS; columns++) {

                    gbc.gridx = columns;

                    // make text fields empty
                    inputBoxes[rows][columns] = new JTextField(1);
                    // add text fields to the frame
                    add(inputBoxes[rows][columns], gbc);
                    // center text in each text box
                    inputBoxes[rows][columns].setHorizontalAlignment(JTextField.CENTER);
                    // apply font to each text box
                    inputBoxes[rows][columns].setFont(font);

                } // end of columns loop

                if ((rows + 1) % 3 == 0) {
                    System.out.println("Split");
                    split.gridy = gbc.gridy + 1;
                    gbc.gridy += 2;
                    JSeparator sep = new JSeparator(JSeparator.HORIZONTAL);
                    add(sep, split);
                }

            } // end of rows loop
        }

    }

}