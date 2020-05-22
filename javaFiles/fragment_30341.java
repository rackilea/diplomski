public class Profile2Activity extends Activity {
    //TextViews to show details of volume and brightness
    private TextView tVBrightness, tVVolume;
    //SeekBars to set volume and brightness
    private SeekBar sbVolume, sbBrightness;
    //AudioManager object, that will get and set volume
    private AudioManager audioManager;
    //Variable to store brightness value
    private int brightness;
    //Content resolver used as a handle to the system's settings
    private ContentResolver cResolver;
    //Window object, that will store a reference to the current window
    private Window window;
    int maxVolume = 1;

    EditText e2;
    Button b2;
    public static final String MyPREFERENCESS = "MyPrefss";

    public static final String OFFICEWIFI = "officewifi";
    Context context = this;
    private AudioManager myAudioManager;
    SharedPreferences sharedpreferences;

    public static final String BRIGHTNESS = "brightness";
    public static final String VOLUME = "volume";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile2);
        //Suggests an audio stream whose volume should be changed by the hardware volume controls.
        setVolumeControlStream(AudioManager.STREAM_MUSIC);
        // initializeControls2();
        myAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        e2 = (EditText) findViewById(R.id.ed1);
        b2 = (Button) findViewById(R.id.but1);
        sbVolume = (SeekBar) findViewById(R.id.sbVolume);
        sbBrightness = (SeekBar) findViewById(R.id.sbBrightness);
        tVVolume = (TextView) findViewById(R.id.tVVolume);
        tVBrightness = (TextView) findViewById(R.id.tVBrightness);

        sharedpreferences = getSharedPreferences(MyPREFERENCESS, Context.MODE_PRIVATE);
        final String officewifi = sharedpreferences.getString(OFFICEWIFI, "");
        e2.setText(officewifi);

        Log.d("VOLUME", "" + sharedpreferences.getInt(VOLUME, 0));
        Log.d("BRIGHTNESS", "" + sharedpreferences.getInt(BRIGHTNESS, 0));

        sbVolume.setProgress(sharedpreferences.getInt(VOLUME, 0));
        sbBrightness.setProgress(sharedpreferences.getInt(BRIGHTNESS, 0));


        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String officewifi = e2.getText().toString();
                SharedPreferences.Editor editor = sharedpreferences.edit();

                editor.putString(OFFICEWIFI, officewifi);
                //Suhas
                editor.putInt(BRIGHTNESS, sbBrightness.getProgress());
                editor.putInt(VOLUME, sbVolume.getProgress());

                editor.commit();
                Toast.makeText(Profile2Activity.this, "Thanks", Toast.LENGTH_SHORT).show();
            }
        });

////////////////////////////////////////////////////////////////////////////////////

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {

            @Override
            public void run() {
//
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo mWifi = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);

                if (mWifi.isConnected()) {
                    final WifiManager wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
                    final WifiInfo con = wifiManager.getConnectionInfo();
                    //Toast.makeText(MainActivity.this, con.getSSID()+"",Toast.LENGTH_LONG).show();

                    if (con.getSSID().toString().equalsIgnoreCase("\"" + officewifi + "\"")) {
                        initializeControls2();
                    } else {
                        myAudioManager.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
// Toast.makeText(MainActivity.this, "Now in Ringing Mode", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    myAudioManager.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
// Toast.makeText(MainActivity.this, "Now in Ringing Mode", Toast.LENGTH_SHORT).show();
                }
                handler.postDelayed(this, 1000);
            }
        }, 1000);

    }


    private void initializeControls2() {
//get reference of the UI Controls

        try {

            audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
            //set max progress according to volume
            sbVolume.setMax(audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC));
            //get current volume
            sbVolume.setProgress(audioManager.getStreamVolume(AudioManager.STREAM_MUSIC));
            //Set the seek bar progress to 1
            sbVolume.setKeyProgressIncrement(1);
            //get max volume
            maxVolume = sbVolume.getMax();
            sbVolume.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {
                }

                @Override
                public void onProgressChanged(SeekBar seekBar, int progress,
                                              boolean fromUser) {
                    audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, progress, 0);
                    float perc = (progress / (float) maxVolume) * 100;
                    //Set the brightness percentage
                    tVVolume.setText("Volume: " + (int) perc + " %");
                }
            });

        } catch (Exception e) {

        }


//Get the content resolver
        cResolver = getContentResolver();

//Get the current window
        window = getWindow();

//Set the seekbar range between 0 and 255
        sbBrightness.setMax(255);
//Set the seek bar progress to 1
        sbBrightness.setKeyProgressIncrement(1);

        try {
//Get the current system brightness
            brightness = System.getInt(cResolver, System.SCREEN_BRIGHTNESS);
        } catch (SettingNotFoundException e) {
//Throw an error case it couldn't be retrieved
            Log.e("Error", "Cannot access system brightness");
            e.printStackTrace();
        }

//Set the progress of the seek bar based on the system's brightness
        sbBrightness.setProgress(brightness);

//Register OnSeekBarChangeListener, so it can actually change values
        sbBrightness.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
            public void onStopTrackingTouch(SeekBar seekBar) {
//Set the system brightness using the brightness variable value
                System.putInt(cResolver, System.SCREEN_BRIGHTNESS, brightness);
//Get the current window attributes
                LayoutParams layoutpars = window.getAttributes();
//Set the brightness of this window
                layoutpars.screenBrightness = brightness / (float) 255;
//Apply attribute changes to this window
                window.setAttributes(layoutpars);
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
//Nothing handled here
            }

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
//Set the minimal brightness level
//if seek bar is 20 or any value below
                if (progress <= 20) {
//Set the brightness to 20
                    brightness = 20;
                } else //brightness is greater than 20
                {
//Set brightness variable based on the progress bar
                    brightness = progress;
                }
//Calculate the brightness percentage
                float perc = (brightness / (float) 255) * 100;
//Set the brightness percentage
                tVBrightness.setText("Brightness: " + (int) perc + " %");
            }
        });
    }

}