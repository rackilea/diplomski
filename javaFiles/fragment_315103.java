public void playSound(){
    // Initialize the alert and ringtone again. 
    MainActivity.alert = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
    MainActivity.r = RingtoneManager.getRingtone(getApplicationContext(), alert);

    MainActivity.r.play();
}

public void onDestroy() {
    MainActivity.r.stop();
    super.onDestroy();
}