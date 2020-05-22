public class MainActivity extends Activity {
private int i = 0;
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

            //  let i be previously saved value or default to zero
            i = app_preferences.getInt("Scores: ",0);

    Button btn = (Button) findViewById(R.id.but);
    final TextView txt = (TextView) findViewById(R.id.txt);

    final SharedPreferences app_preferences = PreferenceManager.getDefaultSharedPreferences(this);
    btn.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            SharedPreferences.Editor editor = app_preferences.edit();

            i++;
            txt.setText(" " + i);

            //i++;  maybe DONT really increment twice (unless thats what you intended)
            editor.putInt("Scores: ", i);
            editor.commit();
        }
    });


}

  }