private final Runnable buttonPressedRunnable = new Runnable() {
    @Override
    public void run() {
        // Check if the Button is pressed
        if(buttonPressed) {
            // Insert whatever you want to do while the Button is pressed here
            ...

            // Repost the Runnable with an appropriate delay
            button.postDelayed(this, 100);
        }
    }
};