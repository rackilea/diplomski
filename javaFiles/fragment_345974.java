public class MainActivity extends ActionBarActivity {

    private ImageView ivImage = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = (int) (displayMetrics.heightPixels/displayMetrics.density);
        int width = (int) (displayMetrics.widthPixels/displayMetrics.density);

        // Calculate ActionBar height
        TypedValue tv = new TypedValue();
        int actionBarHeight=0;
        if (getTheme().resolveAttribute(android.R.attr.actionBarSize, tv, true))
        {
            actionBarHeight = TypedValue.complexToDimensionPixelSize(tv.data,getResources().getDisplayMetrics());
        }

        ivImage = (ImageView) findViewById(R.id.iv_image);
        RelativeLayout.LayoutParams param = new RelativeLayout.LayoutParams(displayMetrics.widthPixels, (displayMetrics.heightPixels-actionBarHeight-getStatusBarHeight()));
        ivImage.setLayoutParams(param);
    }

    public int getStatusBarHeight() {
        int result = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

}