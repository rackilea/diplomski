public static boolean interrupted;
    public void wait()
    {
    interrupted = false;
    //this is just the boolean value allowing the countdown to be interrupted as you requested.
    Integer currentTime = 15;
    //set the integer value of the countdown time.
    while(currentTime > 0 || interrupted){
    //must throw InterruptedException here.
    Thread.sleep(1000);
    currentTime--;
    //'timerText' is just the graphics object displaying the current countdown state.
    timerText.setText(currentTime.toString);

    }
    currentTime = 15;
    interrupted = false;
    //resetting the values
    }