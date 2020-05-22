public class ImageViewer extends AppCompatActivity {

    private ImageView imgView;
    private String fullScreenInd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_viewer);

        Uri myUri = Uri.parse(getIntent().getExtras().getString("imageUri"));
        imgView = (ImageView)findViewById(R.id.fullImageView);
        imgView.setImageURI(myUri);

        imgView.getLayoutParams().height = ViewGroup.LayoutParams.MATCH_PARENT;
        imgView.getLayoutParams().width = ViewGroup.LayoutParams.MATCH_PARENT;
        imgView.setAdjustViewBounds(false);
        imgView.setScaleType(ImageView.ScaleType.FIT_XY);

    }
}