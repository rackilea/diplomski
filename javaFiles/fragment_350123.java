//global variables
private int currTime = 10;
private TextView myTimer;//need to initialize this in your layout using findViewById, or programmatically

final Timer t = new Timer();
currTime = 10;
t.scheduleAtFixedRate(new TimerTask() {
    @Override
    public void run() {
        runOnUiThread(new Runnable() {//You need this, or a Handler to ensure the UI is changed on the correct thread.
            currTime--;
            myTimer.setText(currTime);//myTimer is a global reference to your TextView.
            if (currTime == 0)
                t.cancel();
        });
    }
}, 10000);//note that this is the duration in milliseconds (1/1000 of a second) - so 10000 for 10 seconds.