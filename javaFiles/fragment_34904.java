import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class Swinggg2 extends JPanel {
    // default table model holds no data, but displays the column header names, course/grade
    private MyTableModel tableModel = new MyTableModel(0);
    private JTable myTable = new JTable(tableModel);

    // get the number of courses in a JSpinner, from 1 to 100
    private JSpinner spinner = new JSpinner(new SpinnerNumberModel(1, 1, 100, 1));
    private JTextField averageField = new JTextField(10);

    public Swinggg2() {
        // create our GUI
        // first the top JPanel to get the number of courses
        JPanel courseNumberPanel = new JPanel();
        courseNumberPanel.add(new JLabel("Please enter the number of courses that you completed in Fall 17/18:"));
        courseNumberPanel.add(spinner);
        courseNumberPanel.add(new JButton(new AbstractAction("Show Courses") {

            @Override
            public void actionPerformed(ActionEvent e) {
                int rowCount = (int) spinner.getValue();
                tableModel = new MyTableModel(rowCount);
                myTable.setModel(tableModel);
            }
        }));

        // then the JScrollPane to hold the JTable
        JScrollPane scrollPane = new JScrollPane(myTable);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        // then create the bottom JPanel to calculate and display the average grade
        averageField.setEditable(false);
        JPanel calcAveragePanel = new JPanel();
        calcAveragePanel.add(new JLabel("Calculated Average Grade:"));
        calcAveragePanel.add(averageField);
        calcAveragePanel.add(new JButton(new AbstractAction("Calculate Average") {

            @Override
            public void actionPerformed(ActionEvent e) {
                // if user is still editing a cell, STOP editing
                if (myTable.isEditing()) {
                    myTable.getCellEditor().stopCellEditing();
                }

                // extract the average value from the table model and display it
                double average = tableModel.getAverageGrade();
                String averageText = String.format("%.3f", average);
                averageField.setText(averageText);
            }
        }));

        // give the JPanel a layout and add components to it, top, center, bottom
        int gap = 3;
        setBorder(BorderFactory.createEmptyBorder(gap, gap, gap, gap));
        setLayout(new BorderLayout());
        add(courseNumberPanel, BorderLayout.PAGE_START);
        add(scrollPane, BorderLayout.CENTER);
        add(calcAveragePanel, BorderLayout.PAGE_END);
    }

    // create and show the GUI
    private static void createAndShowGui() {
        Swinggg2 mainPanel = new Swinggg2();

        JFrame frame = new JFrame("Course Grade Average");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        // do everything on the Swing event thread
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}