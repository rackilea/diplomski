public class MainActivity extends AppCompatActivity {
    CountDownTimer[] countDownTimers;
    int Time;
    TextView text;
    ArrayList<Integer> timeList;
    int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text= (TextView) findViewById(R.id.text);
        timeList=new ArrayList<>();
        timeList.add(10*1000);
        timeList.add(20*1000);
        timeList.add(30*1000);
        countDownTimers=new CountDownTimer[timeList.size()];
        for(int i=0;i<timeList.size();i++){
            final int finalI = i;
            countDownTimers[i]=new CountDownTimer(timeList.get(finalI),100) {
                @Override
                public void onTick(long millisUntilFinished) {
                    long ms = millisUntilFinished;
                    String texts = String.format("%02d : %02d",
                            TimeUnit.MILLISECONDS.toMinutes(ms) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(ms)),
                            TimeUnit.MILLISECONDS.toSeconds(ms) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(ms)));
                    text.setText(texts);
                }

                @Override
                public void onFinish() {
                     if(!((finalI +1)>=timeList.size())){
                         countDownTimers[finalI+1].start();
                     }
                }
            };
        }
        countDownTimers[0].start();

    }

}