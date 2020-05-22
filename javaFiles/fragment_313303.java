Timer myTimer = new Timer();
MyTimerTask myTimerTask= new MyTimerTask();
AudioManager audioManager;

public void onCreate()
{
    super.onCreate();
    audioManager = (AudioManager)this.getSystemService(Context.AUDIO_SERVICE);
}