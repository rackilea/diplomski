public class DecidePicActivity extends Activity implements OnClickListener{
static boolean takepic = false;
static boolean choosepic = false;
@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT); 
    setContentView(R.layout.decidepic);
    findViewById(R.id.take_pic_button).setOnClickListener(this);
    findViewById(R.id.choose_pic_button).setOnClickListener(this);
}
@Override
public void onClick(View v) {
    switch(v.getId()) {
        case R.id.take_pic_button:
            takepic = true;
            Intent i1 = new Intent(this, TakePictureActivity.class);
            startActivity(i1);
            break;
        case R.id.choose_pic_button:
            choosepic = true;
            Intent i2 = new Intent(this, ChoosePicActivity.class);
            startActivity(i2);
            break;
    }
}