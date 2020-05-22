public NameActivity extands AppCompactActivity{
SharedPreferences sharedPref;
SharedPreferences.Editor editor ;

@SuppressLint("CommitPrefEdits")
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_define_product);

    sharedPref = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

    Set<String> fetch = sharePref.getStringSet(barcode.getText().toString(), null);
     }
}