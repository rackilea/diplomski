public class activity2 extends Activity{
        MediaPlayer mp = null;

        /** Called when the activity is first created. */
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
        setContentView(R.layout.main2);
    //back button that takes u to main.xml
        Button next = (Button) findViewById(R.id.Back);
        next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
            Intent intent = new Intent();
            setResult(RESULT_OK, intent);
            finish();
            }
            } );
        mp = MediaPlayer.create(activity2.this, R.raw.whippingsound);
        //Button that plays sound (whippingsound)
        Button sound = (Button) findViewById(R.id.sound);
            sound.setOnTouchListener(new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {

            switch (event.getAction()) {

            case MotionEvent.ACTION_DOWN:
                mp.setLooping(true);
                mp.start();
                break;

            case MotionEvent.ACTION_UP:
                mp.pause();
                break;
            }

            return true;
        }
     });
   }