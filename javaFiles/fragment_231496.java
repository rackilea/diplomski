@Override
public void onCreate(Bundle savedInstanceState)
{
    super.onCreate(savedInstanceState);
    SharedPreferences mDefaultPreferences = PreferenceManager.getDefaultSharedPreferences(this);
    if (mDefaultPreferences.getBoolean("first_launch", true))
    {
       mDefaultPreferences.edit().putBoolean("first_launch", false).commit();
       //Put the code here of your first launch
    }
    else
    {
       //Not the first launch

    }

}