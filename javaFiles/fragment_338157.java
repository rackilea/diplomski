public String value = "";
public void createInput() {
    buttonInput.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            value = textfieldInput.getText();

        }

    });
}