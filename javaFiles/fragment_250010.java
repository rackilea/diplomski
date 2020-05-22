public class MainActivity extends ActionBarActivity {

        public int score = 0;
        public int highscore;
        TextView tvscore, tvhighscore;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            tvhighscore= (TextView) findViewById(R.id.highscore);
            tvscore = (TextView) findViewById(R.id.score);
            Button count = (Button) findViewById(R.id.button1);


            SharedPreferences prefs = this.getSharedPreferences("myPrefsKey", Context.MODE_PRIVATE);
            highscore = prefs.getInt("high_score", 0);
            tvhighscore.setText(String.valueOf(highscore));
        }

        public void onClick (View view) {
            score++;
            tvscore.setText(String.valueOf(score));
            if (score > highscore) {
                highscore = score;
                SharedPreferences prefs = this.getSharedPreferences("myPrefsKey", Context.MODE_PRIVATE);
                prefs.edit().putInt("high_score", highscore).apply();
                tvhighscore.setText(String.valueOf(highscore));
            }
        }
    }