public class ConfigurerActivity extends ActionBarActivity 
{
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private ActionBarDrawerToggle mDrawerToggle;
    private FrameLayout frame;
    private float lastScale = 1.0f;

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);
        frame = (FrameLayout) findViewById(R.id.content_frame);

        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.drawable.ic_drawer, R.string.acc_drawer_open, R.string.acc_drawer_close) 
        {            
            @SuppressLint("NewApi")
            public void onDrawerSlide(View drawerView, float slideOffset)
            {
                float min = 0.9f;
                float max = 1.0f;
                float scaleFactor = (max - ((max - min) * slideOffset));

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) 
                {
                    frame.setScaleX(scaleFactor);
                    frame.setScaleY(scaleFactor);
                }
                else
                {               
                    ScaleAnimation anim = new ScaleAnimation(lastScale, scaleFactor, lastScale, scaleFactor, frame.getWidth()/2, frame.getHeight()/2);
                    anim.setDuration(0);
                    anim.setFillAfter(true);
                    frame.startAnimation(anim);

                    lastScale = scaleFactor;
                }
            }
        };

        mDrawerLayout.setDrawerListener(mDrawerToggle);

        // ... more of your code
    }
}