RingtoneManager ringtoneManager = new RingtoneManager(getContext());

 public void playRingtone(View view) {
    try {
        Uri path = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.song);
        ringtoneManager.setActualDefaultRingtoneUri(getApplicationContext(), RingtoneManager.TYPE_ALARM, path);
        Ringtone r = ringtoneManager.getRingtone(getApplicationContext(), path);
        r.play();
    } catch (Exception e) {
        e.printStackTrace();
    }
}

public void stopRingtone(){
   ringtoneManager.stopPreviousRingtone();
}