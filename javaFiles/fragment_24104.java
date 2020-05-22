public void actionPerformed(ActionEvent e) {
    Calendar aCalendar = Calendar.getInstance();
    if (e.getSource() == startButton){
        start = aCalendar.getTimeInMillis();
        aJLabel.setText("Stopwatch is running...");
    } else if (e.getSource() == stopButton) {
        aJLabel.setText("Elapsed time is: " + 
                (double) (aCalendar.getTimeInMillis() - start) / 1000 );
    } else if (e.getSource() == pauseButton) {
        // Do pause stuff
    }
}