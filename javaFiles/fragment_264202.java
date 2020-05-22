@Override
public void onCreate(Bundle savedInstanceState)
 {
    super.onCreate(savedInstanceState);
    SharedPreferences pref = YourActivityName.this.getSharedPreferences(PREFS_NAME,0);
    SharedPreferences.Editor editor= pref.edit();
    boolean firstRun = pref.getBoolean("firstRun", true); 
    if(firstRun)
    {
        Log.i("onCreate: ","first time" );
        editor.putBoolean("firstRun",false);
        editor.commit();
        Intent intent = new Intent(getActivity(), TutorialFeaturedActivity.class);
        startActivity(intent);
    }
    else
    {
        Log.i("onCreate: ","second time");
        Intent intent = new Intent(getActivity(), MainActivity.class);
        startActivity(intent);

    }
   // getSpecials();
}