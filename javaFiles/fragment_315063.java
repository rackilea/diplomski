public class SurroundingActivity extends Activity {

    volatile boolean uiIsRunning = false;
    private Handler uiHandler;

    void someMethod () { 
        uiHandler.post(new Runnable() {
            @Override
            public void run() {
                SurroundingActivity.this.uiIsRunning = true;
            }
        });
    }
}