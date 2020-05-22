@Override
protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);    
      SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
      int storedPreference = preferences.getInt("storedInt", 0);
      if (preferences.getString("clicked", "yes").equals("nope")){
          // it never been clicked
      } else {
          // it has been clicked before do whatever you want with the background
      }
      setContentView(R.layout.activity_home);    
}