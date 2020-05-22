/** Called when the activity is first created. */
@Override
public void onCreate(Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);

    tv1 = (TextView) findViewById(R.id.textView1);
    tv2 = (TextView) findViewById(R.id.textView2);
    tv3 = (TextView) findViewById(R.id.textView3);
    tv4 = (TextView) findViewById(R.id.textView4);

    sb1 = (SeekBar) findViewById(R.id.seekBar1);
    sb2 = (SeekBar) findViewById(R.id.seekBar2);
    sb3 = (SeekBar) findViewById(R.id.seekBar3);
    sb4 = (SeekBar) findViewById(R.id.seekBar4);

    sb1.setOnSeekBarChangeListener(OnSeekBarProgress);
    sb2.setOnSeekBarChangeListener(OnSeekBarProgress);
    sb3.setOnSeekBarChangeListener(OnSeekBarProgress);
    sb4.setOnSeekBarChangeListener(OnSeekBarProgress);
}