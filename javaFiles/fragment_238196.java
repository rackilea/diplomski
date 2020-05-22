public class GameSplash extends Activity {

// time to wait on the splash screen
private static final int SPLASH_SCREEN_DELAY = 3000;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.splash);

    new Thread() {
        @Override
        public void run() {
            try {
                // do any heavy initialization here

                // wait a few seconds before going to the next screen
                sleep(SPLASH_SCREEN_DELAY);
            }
            catch (InterruptedException e) {

            }
            catch (Exception e) {

            }
            finally {
                // start the level selection screen
                Intent intentSelect = new Intent(GameSplash.this, GameSelect.class);
                startActivity(intentSelect);
            }
        }
    }.start();

}

@Override
public boolean onKeyDown(int keyCode, KeyEvent event) {
    // ignore any key press on the splash screen
    return true;
}

}