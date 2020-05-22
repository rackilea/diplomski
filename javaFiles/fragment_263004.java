public class MainActivity extends AppCompatActivity {

    Context context;
    TextView textView;
    SharedPreferences preferences;
    String[] SuppertedLangCodes = {"en", "ur"};
    String key = "lang";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        preferences = getSharedPreferences("myprefs", MODE_PRIVATE);

        textView = (TextView) findViewById(R.id.foodName);
        textView.setText(getResources().getText(R.string.txt_name));
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (preferences.getString("lang", "").toString().equalsIgnoreCase("") || preferences.getString("lang", "").toString().equalsIgnoreCase(SuppertedLangCodes[0])) {

                    applyLanguage(context, SuppertedLangCodes[1]);
                    preferences.edit().putString(key, SuppertedLangCodes[1]).apply();
                } else {

                    applyLanguage(context, SuppertedLangCodes[0]);
                    preferences.edit().putString(key, SuppertedLangCodes[0]).apply();
                }
            }
        });
    }

    public void applyLanguage(Context context, String language) {
        android.content.res.Configuration config = new android.content.res.Configuration();
        // Since API level 17 or below cause issues with RTL, lets keep them LTR
        if (android.os.Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN_MR2) {
            config.locale = new Locale("en");
        } else {
            config.locale = new Locale(language);
        }
        context.getResources().updateConfiguration(config, context.getResources().getDisplayMetrics());
        recreate();
    }
}