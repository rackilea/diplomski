import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.MatteBorder;

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

            GridBagConstraints groupContraint = new GridBagConstraints();
            groupContraint.fill = GridBagConstraints.BOTH;
            groupContraint.weightx = 1;
            groupContraint.weighty = 1;
            groupContraint.gridwidth = GridBagConstraints.REMAINDER;

            JPanel group = new JPanel(new GridLayout(3, COLUMNS));
            group.setBorder(new MatteBorder(0, 0, 1, 0, Color.BLACK));

            // outer loop to create the rows
            for (int rows = 0; rows < ROWS; rows++) {

                // inner loop to create the columns
                for (int columns = 0; columns < COLUMNS; columns++) {

                    // make text fields empty
                    inputBoxes[rows][columns] = new JTextField(1);
                    // add text fields to the frame
                    group.add(inputBoxes[rows][columns]);
                    // center text in each text box
                    inputBoxes[rows][columns].setHorizontalAlignment(JTextField.CENTER);
                    // apply font to each text box
                    inputBoxes[rows][columns].setFont(font);

                } // end of columns loop

                if ((rows + 1) % 3 == 0) {
                    add(group, groupContraint);
                    group = new JPanel(new GridLayout(3, COLUMNS));
                    group.setBorder(new MatteBorder(0, 0, 1, 0, Color.BLACK));
                }

            } // end of rows loop
        }

    }

}