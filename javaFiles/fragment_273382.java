public class HighScoreActivity extends AppCompatActivity {

TextView highScoreTextView;
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_high_score);

    SharedPreferences sharedPreferences = getSharedPreferences("sharedPreferences",MODE_PRIVATE);
    int storedHighScore = sharedPreferences.getInt("highScore",0);

    highScoreTextView=(TextView)findViewById(R.id.textHighScore);
    highScoreTextView.setText(""+storedHighScore);


    }
}