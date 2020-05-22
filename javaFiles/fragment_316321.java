public class SplashActivity extends Activity{

protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_splash);

// decide here whether to navigate to Login or Main Activity 

    SharedPreferences pref = getSharedPreferences("ActivityPREF", Context.MODE_PRIVATE);
    if (pref.getBoolean("activity_executed", false)) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    } else {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}

}