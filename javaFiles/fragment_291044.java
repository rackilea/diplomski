public class YourActivity extends AppCompatActivity {

    ToggleButton onOff;
    boolean playing = false;


    // Once the app start recording, the recording thread freezes the screen because of the while loop, the it works
    //directly with the main thread hence doesnt release the hand until forced to stop
    //For that we need to create it's own thread hence being able to play sound without freezing the remaining of the app
    //private Handler myHandler


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_main);

        //Handler

        //Route the sound to the AUX only and always
        AudioManager audioManager = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
        audioManager.setMode(AudioManager.MODE_IN_CALL);
        audioManager.setSpeakerphoneOn(false);
        audioManager.setWiredHeadsetOn(true);
        audioManager.setBluetoothScoOn(false);

        final playerTask pl_task = new playerTask();
      /////Use a toggle button to start or stop the recording///You could use anything
        onOff = (ToggleButton)findViewById(R.id.OnOff);
        onOff.setTextOff("PLAY");
        onOff.setTextOn("STOP");
        onOff.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            public void onCheckedChanged(CompoundButton buttonview, boolean isCheked){
                //Running thread

                if (isCheked){
                    messagefield.setText("Playing");
                    pl_task.execTask();  ///Start streaming

                }
                else{
                    messagefield.setText("Not Playing");
                    pl_task.abortTask();  ///Stop streaming

                }
            }
        });