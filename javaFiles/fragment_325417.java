Timer timer = new Timer(HIGHLIGHT_TIME, new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        jLabel1.setText("MDK");
    }
});
timer.setRepeats(false);
timer.start();