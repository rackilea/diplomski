txtTest.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent evt) {
        testInput = txtTest.getText();
        txtTest.setText(testInput);
    }
});