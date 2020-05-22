public class BaseActivity extends Activity {
    private boolean mDestroyed;

    public boolean isDestroyed(){
        return mDestroyed;
    }

    @Override
    protected void onDestroy() {
        mDestroyed = true;
        super.onDestroy();
    }
}