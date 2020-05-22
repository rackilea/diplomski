@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // create RangeSeekBar as Integer range between 20 and 75
        RangeSeekBar<Integer> seekBar = new RangeSeekBar<Integer>(20, 75, this);
        seekBar.setOnRangeSeekBarChangeListener(new OnRangeSeekBarChangeListener<Integer>() {
            @Override
            public void onRangeSeekBarValuesChanged(RangeSeekBar<?> bar,
                    Integer minValue, Integer maxValue) {
                  // handle changed range values
                 String powerranger = "User selected new range values: MIN=" + minValue + ", MAX=" + maxValue;
                  //Log.i(TAG, powerranger);
                 textView1.setText(powerranger);
            }
        });

        // add RangeSeekBar to pre-defined layout
        ViewGroup layout = (ViewGroup) findViewById(R.id.root_view);
        layout.addView(seekBar);
    }