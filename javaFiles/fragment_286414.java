public static final Integer[] TIME_IN_MINUTES = { 30, 45, 60, 180, 360 };
public MediaPlayer mediaPlayer;
public Handler handler = new Handler();
public Button button1;
public Spinner spinner1;

// Initialize the activity
@Override
public void onCreate(Bundle bundle) {
    super.onCreate(bundle);
    setContentView(R.layout.ocean);

    button1 = (Button) findViewById(R.id.btn1);
    button1.setOnClickListener(this);
    spinner1 = (Spinner) findViewById(R.id.spinner1);
    ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(this,
            android.R.layout.simple_spinner_item, TIME_IN_MINUTES);

    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    spinner1.setAdapter(adapter);
}

// Play the sound and start the timer
private void playSound(int resourceId) {
    // Cleanup any previous sound files
    cleanup();
    // Create a new media player instance and start it
    mediaPlayer = MediaPlayer.create(this, resourceId);
    mediaPlayer.start();
    // Create the timer to stop the sound after x number of milliseconds
    int selectedTime = TIME_IN_MINUTES[spinner1.getSelectedItemPosition()];
    handler.postDelayed(runnable, selectedTime * 60 * 1000);
}

// Handle button callback
@Override
public void onClick(View v) {
    switch (v.getId()) {
    case R.id.btn1:
        playSound(R.raw.test);
        /*
         * getResources().openRawResource(R.raw.test);
         */break;
    }
}

// Stop the sound and cleanup the media player
public void cleanup() {
    if (mediaPlayer != null) {
        mediaPlayer.stop();
        mediaPlayer.release();
        mediaPlayer = null;
    }
    // Cancel any previously running tasks
    handler.removeCallbacks(runnable);
}

// Runnable task used by the handler to stop the sound
public Runnable runnable = new Runnable() {
    public void run() {
        cleanup();
    }
};