txtTest.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent evt) {
        testInput = txtTest.getText();
        lblTest.setText(testInput);    //This line was changed.
    }
});