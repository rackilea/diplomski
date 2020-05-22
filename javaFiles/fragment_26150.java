public class SettingsActivity extends Activity {

    // a field for preference
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedpreferences = getSharedPreferences("MyPreference", Context.MODE_PRIVATE);
        editor = sharedpreferences.edit();

        // for example, edit the value using a button at runtime
        Button button = (Button)findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putString(SERVER, server.toString());
            }
        });
        ...
    }

    @Override
    protected void onDestroy(){
        // call commit to save all changes
        editor.commit();
        super.onDestroy();
    }
}