Runnable timerRunnable = new Runnable() {

    @Override
    public void run() {
        long millis = System.currentTimeMillis() - startTime;
        int seconds = (int) (millis / 1000) * 1;
        int minutes = seconds / 60;
        seconds = seconds % 60;  
        millis = millis % 1000;              

        timerTextView.setText(String.format("%02d:%02d", minutes, seconds));
        Log.d("MainActivity", String.format(Locale.ENGLISH,"Checking time: %02d:%02d:%03d" , minutes, seconds, millis));
        timerHandler.postDelayed(this, 500);

        if (minutes == 45 && seconds == 0) {
            Log.d("MainActivity", String.format(Locale.ENGLISH,"2nd Half: %02d:%02d:%03d" , minutes, seconds, millis));
            addHeader("2nd Half");                   
        }  
    }