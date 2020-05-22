public class SettingsActivity extends Activity implements OnClickListener {

    private SharedPreferencesManager prefs; //added

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        prefs = new SharedPreferencesManager(this); //get SharedPreferencesManager  instance
        int t = prefs.retrieveInt("theme", 0); //get stored theme, zero is default
        ThemeUtils.setTheme(t);  //Set the stored theme, will default to Black

        ThemeUtils.onActivityCreateSetTheme(this);

        setContentView(R.layout.settings);

        findViewById(R.id.blackbutton).setOnClickListener(this);

        findViewById(R.id.bluebutton).setOnClickListener(this);

        findViewById(R.id.pinkbutton).setOnClickListener(this);
    }

    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.blackbutton:

                prefs.storeInt("theme", 0); //store black theme
                ThemeUtils.changeToTheme(this, ThemeUtils.BLACK);
                break;

            case R.id.bluebutton:

                prefs.storeInt("theme", 1); //store blue theme
                ThemeUtils.changeToTheme(this, ThemeUtils.BLUE);
                break;

            case R.id.pinkbutton:

                prefs.storeInt("theme", 2); //store pink theme
                ThemeUtils.changeToTheme(this, ThemeUtils.PINK);
                break;
        }
    }
}