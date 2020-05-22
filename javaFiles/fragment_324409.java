public class BaseActivity extends Activity {
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK || keyCode == 6 || keyCode==KeyEvent.KEYCODE_HOME) { 
            // Do Something fancy
        }
    // ...
}

public class MyActivity extends BaseActivity {
    // ...
}