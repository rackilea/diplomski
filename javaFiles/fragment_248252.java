public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    ScreenBrightnessSeekBar = (SeekBar)findViewById(R.id.seekBrightness);

    //Brightness is a float-point number between 0 and 1，But getProess() returns Int, so, we can setMax(100), and then we div 100 later.

    ScreenBrightnessSeekBar.setMax(100);  
    ScreenBrightnessSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {  

        public void onStopTrackingTouch(SeekBar seekBar) {}  

        public void onStartTrackingTouch(SeekBar seekBar) {}  

        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            setScreenBrightness((float)seekBar.getProgress()/100);
        }  
    });
}

private void setScreenBrightness(float b){

    //get window attributes and save in layoutParams
    WindowManager.LayoutParams layoutParams = getWindow().getAttributes();  
    layoutParams.screenBrightness = b;

    //display the new brightness
    getWindow().setAttributes(layoutParams);
}