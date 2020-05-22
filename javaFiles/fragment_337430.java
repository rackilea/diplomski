Timer timer = new Timer(1000, new TimerListener());

class TimerListener implements ActionListener{
    int elapsedSeconds = 30;

    public void actionPerformed(ActionEvent evt){
        elapsedSeconds--;
        timerLabel.setText(elapsedSeconds)
        if(elapsedSeconds <= 0){
            timer.stop();
            wrong()
            // fill'er up here...
        }
    }

}