public class MainActivity extends AppCompatActivity {

    static final int DAY_VIEW_MODE = 0;
    static final int WEEK_VIEW_MODE = 1;

    private SharedPreferences mPrefs;
    private int mCurViewMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        System.out.println("onCreate() ");
       // you are creating an another mPrefs reference local to oncreate function
       //  which is different from the global one ,so remove this 
       // SharedPreferences mPrefs = getSharedPreferences("MyPrefFile", 0);
        mPrefs = getSharedPreferences("MyPrefFile", 0); // use this
        mCurViewMode = mPrefs.getInt("view_mode", DAY_VIEW_MODE);
    }

    protected void onPause() {
        super.onPause();

        System.out.println("onPause() ");
        // you can do the same for editor to make it accessible to all functions 
        SharedPreferences.Editor ed = mPrefs.edit();
        ed.putInt("view_mode", mCurViewMode);
        ed.commit();
    }
}