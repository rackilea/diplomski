btnNewButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        counter--;
        if (counter <= 10) {
            lblBrickStock.setText(counter + " remaining");
        }
    }
});