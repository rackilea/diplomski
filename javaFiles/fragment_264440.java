public class RadioButtonPanel extends JPanel {
JRadioButton jRadioButton;
JTextField jTextField;

RadioButtonPanel(String radioButtonName) {
    jRadioButton = new JRadioButton(radioButtonName);
    jTextField = new JTextField(10);
    this.setLayout(new FlowLayout());
    this.add(jRadioButton);
    this.add(jTextField);

    jRadioButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            handleEvent();
        }
    });
}

private void handleEvent() {
    System.out.println(jRadioButton.getText() + " is selected, the customized text is " + jTextField.getText());
}

public static void main(String[] args) {
    JFrame jFrame = new JFrame();

    RadioButtonPanel radioButtonPanel1 = new RadioButtonPanel("Apple");
    RadioButtonPanel radioButtonPanel2 = new RadioButtonPanel("Banana");
    RadioButtonPanel radioButtonPanel3 = new RadioButtonPanel("Pear");
    ButtonGroup buttonGroup = new ButtonGroup();
    buttonGroup.add(radioButtonPanel1.jRadioButton);
    buttonGroup.add(radioButtonPanel2.jRadioButton);
    buttonGroup.add(radioButtonPanel3.jRadioButton);

    jFrame.setLayout(new GridLayout(3, 1, 5, 5));
    jFrame.add(radioButtonPanel1);
    jFrame.add(radioButtonPanel2);
    jFrame.add(radioButtonPanel3);
    jFrame.pack();
    jFrame.setVisible(true);
}
}