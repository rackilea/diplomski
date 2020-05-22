import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class SimpleCalcGui extends JPanel {
    private static final long serialVersionUID = 1L;
    private JTextField field1 = new JTextField(5);
    private JTextField field2 = new JTextField(5);
    private JTextField resultField = new JTextField(5);
    private JButton calcButton = new JButton("Calculate");

    public SimpleCalcGui() {
        resultField.setFocusable(false);
        calcButton.addActionListener(new CalcListener());

        add(field1);
        add(new JLabel("+"));
        add(field2);
        add(new JLabel("="));
        add(resultField);
        add(calcButton);
    }

    private class CalcListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                // extract the values and convert to numbers
                int value1 = Integer.parseInt(field1.getText());
                int value2 = Integer.parseInt(field2.getText());

                // call MyCalc's method passing in the values
                int result = MyCalc.addition(value1, value2);

                // display the result
                resultField.setText("" + result);

            } catch (NumberFormatException e1) {
                JOptionPane.showMessageDialog(calcButton, "Both text fields must have valid numbers",
                        "Numeric Entry Error", JOptionPane.ERROR_MESSAGE);
                field1.setText("");
                field2.setText("");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }

    private static void createAndShowGui() {
        SimpleCalcGui mainPanel = new SimpleCalcGui();
        JFrame frame = new JFrame("SimpleCalcGui");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(mainPanel);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }
}