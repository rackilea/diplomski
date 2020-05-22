rand = new Random();
timer = new Timer();
int mean = 105, standardDeviation = 5;
timer.schedule(new TimerTask() {

@Override
public void run() {
    Integer sbp;
    do
    {
        sbp = (int) Math.round((rand.nextGaussian() * standardDeviation) + mean);
    } 
    while(sbp < 80 || sbp > 130)

    lblSBPCounter.setText(Integer.toString(sbp));           
}
}, 1000, 120000);