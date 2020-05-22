SharedPreferences sharedPref;
SharedPreferences.Editor editor ;
Set<String> set = new HashSet<>();

@SuppressLint("CommitPrefEdits")
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_define_product);

    sharedPref = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
    editor = sharedPref.edit();

}

public void Save(View view){
    editor.putStringSet(barcode.getText().toString(),set);
    editor.apply();
    Toast.makeText(getApplicationContext(),"Saved", Toast.LENGTH_LONG).show();
    set.clear();
}