public class FirstFrame extends JFrame {
    // Reference to the second frame...
    // You will need to ensure that this is assigned correctly...
    private SecondFrame secondFrame;
    // The text field...
    private JTextField textField;

    /*...*/

    // The action handler for the button...
    public class ButtonActionHandler implements ActionListener {
        public void actionPerformed(ActionEvent evt) {
            secondFrame.setLabelText(textField.getText());
        }
    }
}