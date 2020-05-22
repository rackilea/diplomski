public class FightScreen extends AppCompatActivity implements View.OnClickListener {  
   long lastClickTime = 0;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_fight_screen);

      final Button fightButton = (Button) findViewById(R.id.fightButton);
      final TextView timeText = (TextView) findViewById(R.id.timeText);
      final long bootTime = SystemClock.elapsedRealtime();
      lastClickTime = bootTime;
      fightButton.setOnClickListener(this);// the listener is this class now


    @Override
    public void onClick(View v) {   
        Long timeNow = SystemClock.elapsedRealtime();
        Long timeElapsed = SystemClock.elapsedRealtime() - lastClickTime;   
        lastClickTime = timeNow;
        timeText.setText(String.valueOf(timeElapsed));
    }



}