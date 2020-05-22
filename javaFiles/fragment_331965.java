private int minimal = 30;
private int max = 1000;
int randomTimeOutput; 
Random randomTime;
Timer timerRunAction

public Object() {
    randomTime = new Random();
    randomTimeOutput =  (minimal + randomTime.nextInt(max - minimal + 1));
    timerRunAction = new Timer(randomTimeOutput, this);
    timerRunAction.start();
}

private void doSomething() {
    //Do something
}

private void updateTimer() {
    timerRunAction.stop();
    randomTimeOutput =  (minimal + randomTime.nextInt(max - minimal + 1));
    timerRunAction.setDelay(randomItemOutput);
    timerRunAction.restart();
}

public void actionPerformed(ActionEvent e) {
    dosomething();
    updateTimer();
}