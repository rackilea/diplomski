Timer timer = new Timer(PERIOD, new ActionListener() {
    public void actionPerformed(ActionEvent evt) {
        // Executed later...
    }
});
timer.start();
// Not waiting, continue execution...