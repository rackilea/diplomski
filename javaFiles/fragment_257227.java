final JPanel pnlChange = pnlArray [count - 2][count2];
pnlChange.setBackground (Color.RED);

java.util.Timer timer = new java.util.Timer ();
TimerTask task = new TimerTask () {
    int seconds = 4;
    int divisor = 0;

    @Override
    public void run() {

            divisor++;

            if (divisor % seconds == 0) {
                timer.cancel ();
                pnlChange.setBackground (null);
            }
    }
};

timer.schedule(task, 0, 1000);