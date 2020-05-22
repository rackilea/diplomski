public class AndroidLauncher extends AndroidApplication implements PlatformAdapter {
    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
        config.r = 8;
        config.g = 8;
        config.b = 8;
        config.a = 8;
        config.useWakelock = true;
        initialize(new MyGame(this), config);
    }

    @Override
    public void showToast(String message){
        runOnUiThread( new Runnable(){ public void run() {
            Toast.makeText(this, message, Toast.LENGTH_SHORT);
        }});
    }
}