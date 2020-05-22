int timeDelay = 1000;
ActionListener time;
time = new ActionListener() {

    @Override
    public void actionPerformed(ActionEvent evt) {
        timeLabel.setText(DateTimeUtil.getTime()); 
        /* timeLabel is a JLabel to display time,
           getTime() is samll static methos to return 
           formatted String of current time */
    }
};

new Timer(timeDelay, time).start();