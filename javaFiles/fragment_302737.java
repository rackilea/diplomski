public class Job implements Runnable{
    private Handler handler;

    public Job () {
       handler = new Handler(Looper.getMainLooper());
       loop();
    }

    @Override
    public void run() {
        // funky stuff
        loop();
    }

    private void loop() {
        handler.postDelayed(this, 1000);
    }
}