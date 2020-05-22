@Override 
protected void onCreate(Bundle savedInstanceState) { 
  super.onCreate(savedInstanceState); 
  sharedPrefs = getSharedPreferences("Mes_Parametres", MODE_PRIVATE); 
  data = this.getSharedPreferences("Mes_Parametres", MODE_PRIVATE); 
  monParametreUrl = data.getString("ParametreUrl", null); 

  setContentView(R.layout.activity_pre_load_screen); 

  // rest of your onCreate() code goes here
}