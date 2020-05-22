public class MainActivity extends Activity /**implements OnClickListener**/ {

ImageView image;
Activity context;
Preview preview;
Camera camera;
Button exitButton;
ImageView fotoButton;
ImageView webButton;
LinearLayout progressLayout;
String path = "/sdcard/KutCamera/cache/images/";

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    context=this;

    webButton = (ImageView) findViewById(R.id.imageView_world);
    fotoButton = (ImageView) findViewById(R.id.imageView_foto);
    exitButton = (Button) findViewById(R.id.button_exit);
    image = (ImageView) findViewById(R.id.imageView_photo);
    progressLayout = (LinearLayout) findViewById(R.id.progress_layout);

    preview = new Preview(this,
            (SurfaceView) findViewById(R.id.KutCameraFragment));
    FrameLayout frame = (FrameLayout) findViewById(R.id.preview);
    frame.addView(preview);
    preview.setKeepScreenOn(true);
    fotoButton.setOnClickListener(new OnClickListener() {

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            try {
                takeFocusedPicture();
            } catch (Exception e) {

            }
            exitButton.setClickable(false);
            fotoButton.setClickable(false);
            webButton.setClickable(true);
            progressLayout.setVisibility(View.VISIBLE);
        }
    });
    webButton.setOnClickListener(new OnClickListener() {

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            Intent myIntent = new Intent(MainActivity.this, WebActivity.class);
            MainActivity.this.startActivity(myIntent);

        }
    });
}