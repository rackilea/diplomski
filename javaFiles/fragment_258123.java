public class MainActivity extends AbstractMediaPickerActivity {


    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnGallery = (Button) findViewById(R.id.btnGallery);
        btnGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                startMediaPicker();
            }
        });
    }

    protected void onImagePicked(String picturePath) {
        Intent uploadActivity = new Intent(Main.this, Upload.class);
        uploadActivity.putExtra("picturePath", picturePath);
        startActivity(uploadActivity);
    }

}


public class Upload extends AbstractMediaPickerActivity {


    /** Called when the activity is first created. */

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload);
        Bundle extras = getIntent().getExtras();
        String picturePathView = extras.getString("picturePath");
        ImageView imageView = (ImageView) findViewById(R.id.imgView);
        findViewById(R.id.imgView).setScrollBarStyle(
                View.SCROLLBARS_INSIDE_INSET);
        imageView.setImageBitmap(BitmapFactory.decodeFile(picturePathView));

        Button btnGallery = (Button) findViewById(R.id.btnGallery);
        btnGallery.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                startMediaPicker();
            }
        });
    }

    @Override
    protected void onImagePicked(String picturePath) {
           ImageView imageView = (ImageView) findViewById(R.id.imgView);
            findViewById(R.id.imgView).setScrollBarStyle(
                    View.SCROLLBARS_INSIDE_INSET);
            imageView.setImageBitmap(BitmapFactory.decodeFile(picturePath));    
    }

}