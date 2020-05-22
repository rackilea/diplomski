public class ActivityPreferences extends PreferenceActivity
{
    protected void onCreate( Bundle savedInstanceState )
    {
        super.onCreate( savedInstanceState );
        addPreferencesFromResource( R.xml.preferences );

        Preference myPref = findPreference( "MY_PREF" );
        myPref.setOnPreferenceClickListener( new OnPreferenceClickListener()
        {
            public boolean onPreferenceClick( Preference pref )
            {
                  // Run your custom method
            }
        } );
    }
}