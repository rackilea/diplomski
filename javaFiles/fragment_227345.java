public class BuildMyAppGui {
    //...
    private void initiateTimer() {

            Timer timer = new Timer();
            long zeroDelay = 0L;
            long period = 60000L; // 60 * 1000 = 1 min

            // The timer runs once the first time
            // and subsequently the scheduled task every one minute
            timer.schedule(new DataChangedTask(), zeroDelay, period);
    }
    //...
}