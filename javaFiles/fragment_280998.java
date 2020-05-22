Timer timer = new Timer(true);
timer.scheduleAtFixedRate(new Ticker(), 1000, 1000);

//...

public class Ticker extends TimerTask {
    public void run() {
        // Update static reference to the clock...
    }
}