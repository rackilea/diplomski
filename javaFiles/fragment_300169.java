payButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        double change = Double.valueOf(tenderedTF.getText()) - Double.valueOf(totalTF.getText());
        if(change<0){
            changeTF.setText(String.valueOf(-change) + " missing");
        } else {
            changeTF.setText(String.valueOf(change));
        }
    }
});