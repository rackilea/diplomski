final JButton    aButton    = ...;
final JTextField aTextField = ...;
final String     aNewText   = "New TextField Value";

aButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        aTextField.setText(aNewText);
    }
});