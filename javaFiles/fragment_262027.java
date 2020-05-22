Timer timer = new Timer(3000, new ActionListener() {
    public void actionPerformed(ActionEvent evt) {
        jLabel1.setText(jLabel1.getText()+".");
    }
});
timer.setRepeats(false);
timer.start();