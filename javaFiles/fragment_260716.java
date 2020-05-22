public abstract class BaseActivity extends Activity {
    @Override
    public boolean dispatchKeyEvent(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.KEYCODE_F) {
            Log.d("Test","YOU PRESSED THE F KEY");
            startActivity(new Intent(getApplicationContext(), Activity2.class));
            return true;
        }
        return super.dispatchKeyEvent(e);
    }

}