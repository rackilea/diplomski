private int points;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    SharedPreferences settings = getSharedPreferences("userScore", Context.MODE_PRIVATE);
    if(settings.contains("score"){
        points = settings.getInt("score", userPoints);
    }
    else{
        Log.e(TAG, "No score yet!");

        SharedPreferences.Editor editor = settings.edit();
        editor.putInt("score", 0);
        editor.commit();
    }
}