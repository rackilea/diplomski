SharedPreferences pref = getSharedPreferences("ApplicationTag", Activity.MODE_PRIVATE);

if (pref.contains("FIRST_LAUNCH")){
    finish(); // As you want, it can't be used if the application launches second time.  

} else {
    // Set the first launch flag to true. 
    pref.edit.putBoolean("FIRST_LAUNCH", true).commit();

    // Start the count down timer
    new CountDownTimer(3600000, 1000) {

    public void onTick(long millisRemaining) {
        // Do nothing
    }

    public void onFinish() {
        // Finish the Activity
        finish();
    }

}.start();