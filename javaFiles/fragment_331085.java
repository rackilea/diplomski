public class MainActivity extends AppCompatActivity {

    private boolean mMaleImgClicked, mFemaleImgClicked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView maleImg = (ImageView) findViewById(R.id.male_imageview);
        final ImageView femaleImg = (ImageView) findViewById(R.id.female_imageview);

        maleImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mMaleImgClicked) {
                    maleImg.setImageResource(R.drawable.female_image);

                    mMaleImgClicked = true;
                } else {
                    maleImg.setImageResource(R.drawable.male_image);

                    mMaleImgClicked = false;
                }
            }
        });
        femaleImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mFemaleImgClicked) {
                    femaleImg.setImageResource(R.drawable.male_image);

                    mFemaleImgClicked = true;
                } else {
                    femaleImg.setImageResource(R.drawable.female_image);

                    mFemaleImgClicked = false;
                }
            }
        });
    }
}