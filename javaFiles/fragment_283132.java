myTextField.addActionListener(new ActionListener() {

    @Override
    public void actionPerformed(ActionEvent e) {
       myTextArea.append(myTextField.getText() + "\n");
    }
});