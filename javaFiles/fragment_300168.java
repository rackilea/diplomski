payButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        double change = Double.valueOf(totalTF.getText()) - Double.valueOf(tenderedTF.getText());
        changeTF.setText(String.valueOf(change));
    }
});