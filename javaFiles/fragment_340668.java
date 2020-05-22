public class ProfileSettingsActivity extends AppCompatActivity {

ImageView profileImage1;
ImageView profileImage2;
ImageView profileImage3;
ImageView profileImage4;
ImageView profileImage5;
ImageView profileImage6;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_profile_settings);

    profileImage1 = (ImageView) findViewById(R.id.teamid00);
    profileImage2 = (ImageView) findViewById(R.id.teamid01);
    profileImage3 = (ImageView) findViewById(R.id.teamid02);
    profileImage4 = (ImageView) findViewById(R.id.teamid03);
    profileImage5 = (ImageView) findViewById(R.id.teamid04);
    profileImage6 = (ImageView) findViewById(R.id.teamid05);

    View.OnClickListener clickListener =  new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            setProfilePicture(view);
        }
    };

    profileImage1.setOnClickListener(clickListener);
    profileImage2.setOnClickListener(clickListener);
    profileImage3.setOnClickListener(clickListener);
    profileImage4.setOnClickListener(clickListener);
    profileImage5.setOnClickListener(clickListener);
    profileImage6.setOnClickListener(clickListener);
}

public void setProfilePicture(View view) {
    //Creating a Return intent to pass to the Main Activity
    Intent returnIntent = new Intent();
    //Figuring out which image was clicked
    ImageView selectedImage = (ImageView) view;
    //Adding stuff to the return intent
    returnIntent.putExtra("imageID", selectedImage.getId());
    setResult(RESULT_OK, returnIntent);
    //Finishing Activity and return to main screen!
    finish();
  }
}