SeekBar screenBrightnessSeekBar;

@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    screenBrightnessSeekBar = (SeekBar)findViewById(R.id.seekBrightness);  
    screenBrightnessSeekBar.setMax(255);
    screenBrightnessSeekBar.setProgress((int) (android.provider.Settings.System.getInt(
            getContentResolver(), android.provider.Settings.System.SCREEN_BRIGHTNESS, 255)));

    screenBrightnessSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {  
        public void onStopTrackingTouch(SeekBar seekBar) {}
        public void onStartTrackingTouch(SeekBar seekBar) {}  

        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            if (fromUser) {
                android.provider.Settings.System.putInt(getContentResolver(),
                        android.provider.Settings.System.SCREEN_BRIGHTNESS, progress);

                WindowManager.LayoutParams layoutParams = getWindow().getAttributes();  
                layoutParams.screenBrightness = (float)progress / 255;

                getWindow().setAttributes(layoutParams);
            }
        }
    });
}