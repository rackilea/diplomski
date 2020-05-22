public class MainActivity extends AppCompatActivity {

SeekBar seekBar1;
SeekBar seekBar2;
SeekBar.OnSeekBarChangeListener mlistener;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    seekBar1 = findViewById(R.id.seekBar_1);
    seekBar2 = findViewById(R.id.seekBar_2);

    mlistener = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            switch (seekBar.getId()) {
                case R.id.seekBar_1:
                    //do something
                    break;
                case R.id.seekBar_2:
                    //do something else
                    break;
            }
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    }; 

    seekBar1.setOnSeekBarChangeListener(mlistener);
    seekBar2.setOnSeekBarChangeListener(mlistener);
}