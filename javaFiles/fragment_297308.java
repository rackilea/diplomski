public class MyActivity extends Activity {
    private static final String PREFS_NAME = "MyPrefsFile";
    @Override
    protected void onResume() {
        getContext().getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
            .edit()
            .putInt("activtiyIdRunning", getActivityId() )
            .commit();
        super.onResume();
    }
    abstract protected int getActivityId();
}

public class MyConcreteActivity1 extends MyActivity {
    @Override
    protected int getActivityId() {
        return 1;
    }
    // your normal code
}