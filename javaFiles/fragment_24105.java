public void actionPerformed(ActionEvent e) {
    Calendar aCalendar = Calendar.getInstance();
    if ("Start".equals(e.getActionCommand())){
        start = aCalendar.getTimeInMillis();
        aJLabel.setText("Stopwatch is running...");
    } else if ("Stop".equals(e.getActionCommand())) {
        aJLabel.setText("Elapsed time is: " + 
                (double) (aCalendar.getTimeInMillis() - start) / 1000 );
    } else if ("Pause".equals(e.getActionCommand())) {
        // Do pause stuff
    }
}