private final int FIVE_SECONDS = 5000;
public void scheduleSendLocation() {
    handler.postDelayed(new Runnable() {
        public void run() {
            sendLocation();          // this method will contain your almost-finished HTTP calls
            handler.postDelayed(this, FIVE_SECONDS);
        }
    }, FIVE_SECONDS);
}