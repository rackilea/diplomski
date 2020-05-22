public class RingtonePlayingService extends Service{

    private Ringtone ringtone = null;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId){
        Uri alarmUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
        if (alarmUri == null) 
            alarmUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        this.ringtone = RingtoneManager.getRingtone(this, alarmUri);
        ringtone.play();

        return START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent){
        return null;
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        shutUpRingtone();
    }

    private void shutUpRingtone(){
        if(ringtone != null)
            ringtone.stop();
        ringtone = null;
    }
}