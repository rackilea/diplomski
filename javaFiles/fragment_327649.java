@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);
    SharedPreferences sp;
    SharedPreferences.Editor spe;


    sp = PreferenceManager.getDefaultSharedPreferences(this);
    spe = sp.edit();


    int number= sp.getInt("seekNum", 50);
    SeekBar sb = (SeekBar)findViewById(R.id.slider);
    sb.setMax(100);
    sb.setProgress(number);
    sb.setOnSeekBarChangeListener(this);
}

@Override
public void onProgressChanged(SeekBar v, int progress, boolean isUser) {
    TextView tv = (TextView)findViewById(R.id.percent);
    tv.setText(Integer.toString(progress)+"%");


}


@Override
public void onStop(){
    super.onStop();

    spe.putInt("seekNum", sb.getProgress());
    spe.commit();
}