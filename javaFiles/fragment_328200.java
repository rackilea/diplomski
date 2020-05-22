public class SettingsActivity extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);
    }

    static public void LoadSettings( Activity activity )
    {
        TextView textMain= (TextView) activity.findViewById(R.id.textMain);
        textMain.setMovementMethod(new ScrollingMovementMethod());

        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(activity);

        String textsize = sp.getString("textsize", null);
        if( textsize != null ) {
            textMain.setTextSize( Integer.parseInt( textsize ) );
        }
        String transparency = sp.getString("transparency", null);
        if( transparency != null )  {
            textMain.setBackgroundColor(Color.parseColor(transparency));
        }
    }
}