public class MainActivity extends AppCompatActivity
    implements AppBarLayout.OnOffsetChangedListener {

    private static final float COLLAPSED_TEXT_SIZE_SP = 18f;

    private static final float COLLAPSED_TOP_MARGIN_DP = 24f;

    private static final float MARGIN_SCROLLER_MULTIPLIER = 4f;

    private float expandedTextSize;
    private float collapsedTextSize;

    private int expandedTopMargin;
    private int collapsedTopMargin;

    private AppBarLayout mAppBarLayout;
    private Toolbar mToolbar;
    private TextInputEditText editText;
    private TextInputLayout textInputLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mAppBarLayout = (AppBarLayout) findViewById(R.id.appbar);
        editText = (TextInputEditText) findViewById(R.id.title);
        textInputLayout = (TextInputLayout) findViewById(R.id.lNameLayout);

        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mAppBarLayout.addOnOffsetChangedListener(this);

        expandedTextSize = editText.getTextSize();
        collapsedTextSize = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, COLLAPSED_TEXT_SIZE_SP, getResources().getDisplayMetrics());

        expandedTopMargin = ((ViewGroup.MarginLayoutParams) textInputLayout.getLayoutParams()).topMargin;
        collapsedTopMargin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, COLLAPSED_TOP_MARGIN_DP, getResources().getDisplayMetrics());
    }

    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int offset) {
        int maxScroll = appBarLayout.getTotalScrollRange();
        float percentage = (float) Math.abs(offset) / maxScroll;
        float textSizeDiff = Math.abs(expandedTextSize - collapsedTextSize);
        int marginDiff = Math.abs(expandedTopMargin - collapsedTopMargin);
        //change text size along with scrolling
        editText.setTextSize(TypedValue.COMPLEX_UNIT_PX, expandedTextSize - textSizeDiff * percentage);
        //change top view margin along with scrolling
        ((ViewGroup.MarginLayoutParams) textInputLayout.getLayoutParams()).topMargin = (int) (expandedTopMargin - marginDiff * Math.min(1, percentage * MARGIN_SCROLLER_MULTIPLIER));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}