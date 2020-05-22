public class SecondActivity extends AppCompatActivity
{
private GestureDetectorCompat gestureObject;

TextView mTextView;
ImageView mImageView;
int mIndex;

@Override
protected void onCreate(Bundle savedInstanceState)
{
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_second);

mImageView = (ImageView) findViewById(R.id.imageView);
mTextView = (TextView) findViewById(R.id.textView);

Bundle mBundle = getIntent().getExtras();
if (mBundle != null)
{
    mImageView.setImageResource(mBundle.getInt("flagMedium"));
    mTextView.setText(mBundle.getString("flagName"));
    mIndex = mBundle.getInt("flagBig");
}