Uri alarmUri  = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
   if (alarmUri == null)
    {
      MediaPlayer mp = MediaPlayer.create(getApplicationContext(), notification);
       mp.start();
    }