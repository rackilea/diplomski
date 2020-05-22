public class MainActivity extends AppCompatActivity{
    private View mBottomSheet;
    MyBottomSheetBehavior<View> mBehavior;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        int peekHeight = getResources().getDimensionPixelSize(R.dimen.bottom_sheet_peek_height); // 96dp
        mBottomSheet = findViewById(R.id.bottomSheet);
        mBehavior = (MyBottomSheetBehavior) MyBottomSheetBehavior.from(mBottomSheet);
        mBehavior.setPeekHeight(peekHeight);
    }
}