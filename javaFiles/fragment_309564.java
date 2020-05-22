@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_settings);
    musicSwitch = findViewById(R.id.sLLmusicSwitch);

    SharedPreferences sharedpreferences = getSharedPreferences("save",
            Context.MODE_PRIVATE);
    switchCheckListener();

    musicSwitch.setChecked(sharedpreferences.getBoolean("NameOfThingToSave", false));
}