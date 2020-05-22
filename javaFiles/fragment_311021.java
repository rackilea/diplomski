public class MainActivity extends Activity {


    CountDownTimer workoutTimer;
    CountDownTimer restTimer;

    @Override
    public void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startWorkoutTimer(0);

            }
        });
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (workoutTimer!=null ){
                    workoutTimer.cancel();
                }
                if (restTimer!=null ){
                    restTimer.cancel();
                }
            }
        });

    }


    public void startWorkoutTimer(final int count ){


        workoutTimer=new CountDownTimer(30000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {

                if(count!=3){
                    startRestTimer(count);
                }

            }
        };
        workoutTimer.start();

    }


    public void startRestTimer(final int count ){


        restTimer=new CountDownTimer(15000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {

                if(count!=3){
                    startWorkoutTimer(count+1);
                }

            }
        };
        restTimer.start();

    }




}