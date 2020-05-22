startButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        start = aCalendar.getTimeInMillis();
        aJLabel.setText("Stopwatch is running...");
    }
});
stopButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        aJLabel.setText("Elapsed time is: "
                + (double) (aCalendar.getTimeInMillis() - start) / 1000);
    }
});
pauseButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // Do pause stuff
    }
});