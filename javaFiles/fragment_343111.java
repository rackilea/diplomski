@Override
 protected void onCreate(Bundle savedInstanceState) {
     super.onCreate(savedInstanceState);
     setContentView(R.layout.activity_achievements);
     CheckBox twentyCheck = findViewById(R.id.twentyCheck);
     SharedPreferences settings = getSharedPreferences("GAME DATA", Context.MODE_PRIVATE);
     int highScore = settings.getInt("HIGH_SCORE", 0);
     if (highScore >= 20) {
         twentyCheck.setChecked(true);
     }
 }