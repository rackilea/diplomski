// declare it
SharedPreferences prefs;

public class Methods_play extends Activity {

    public void onCreate(Bundle someBundle)
    {
        super.onCreate(someBundle);
        //initialize it
        prefs = getSharedPreferences(getResources().getString(R.string.preferences), MODE_PRIVATE);