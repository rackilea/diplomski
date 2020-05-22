public class MainActivity extends AppCompatActivity {
RelativeLayout relativeLayout;
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    relativeLayout=findViewById(R.id.parent_panel);
}
public void imageSelector(View view)
{
}
public void up(View view)
{
}
public void viewclick(View view)
{
    HorizontalScrollView horizontalScrollView =
    new HorizontalScrollView(this);
    LinearLayout linearLayout = new LinearLayout(this);
    ViewGroup.LayoutParams prams = new ViewGroup.LayoutParams(
    LinearLayout.LayoutParams.WRAP_CONTENT,
    LinearLayout.LayoutParams.WRAP_CONTENT);
    linearLayout.setLayoutParams(prams);
    linearLayout.setOrientation(LinearLayout.HORIZONTAL);
    horizontalScrollView.addView(linearLayout);
    // mArrayUri is the arraylist of images selected from gallery
    int b = mArrayUri.size();
    int c = 0;
    ImageView[] imageViews = new ImageView[mArrayUri.size()];
    while (c < mArrayUri.size()) {
        imageViews[c] = new ImageView(this);
        imageViews[c].setLayoutParams(new LinearLayout.LayoutParams(
        LinearLayout.LayoutParams.WRAP_CONTENT,
        LinearLayout.LayoutParams.WRAP_CONTENT));
        imageViews[c].setPadding(10, 0, 10, 0);
        imageViews[c].setImageURI(mArrayUri.get(c));
        linearLayout.addView(imageViews[c]);
        c++;
    }
    relativeLayout.addView(horizontalScrollView);
}