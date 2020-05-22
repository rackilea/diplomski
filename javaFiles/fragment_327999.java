Timer timer = new Timer(40, new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // Check to see if the cycle has being completed...
        if (cycleStartedAt == -1) {
            // The time that this cycle started
            cycleStartedAt = System.currentTimeMillis();
        }
        // The amount of time this cycle has being running
        long duration = System.currentTimeMillis() - cycleStartedAt;
        // The progress through this cycle...
        progress = (double)duration / (double)runningTime;
        // Check for the completion of this cycle...
        if (progress > 1.0d) {
            // Reset..
            cycleStartedAt = -1;
            progress = 0;
        }
        repaint();
    }
});
timer.setRepeats(true);
timer.start();