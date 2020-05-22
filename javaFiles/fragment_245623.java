@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    context = this;
    LinearLayout layout = new LinearLayout(this);
    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);

    layout.setOrientation(LinearLayout.VERTICAL);  //Can also be done in xml by android:orientation="vertical"

    int widthOfCell = 20; //(int) squareSize(screenWidth().widthPixels, screenWidth().heightPixels, 9);
    for (int i = 0; i < 5; i++) {
        LinearLayout row = new LinearLayout(this);
        row.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, 1.0f));
        for (int j = 0; j < 5; j++) {
            LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(0, 0, 1.0f);
            DynamicSquareLayout btnTag = new DynamicSquareLayout(this);
            btnTag.setLayoutParams(param);
            btnTag.setText("Button " + (j + 1 + (i * 4 )));
            btnTag.setId(j + 1 + (i * 4));
            row.addView(btnTag);
        }
        layout.addView(row);
    }
    layout.setLayoutParams(params);
    setContentView(layout);
}

class DynamicSquareLayout  extends android.support.v7.widget.AppCompatButton {
    public DynamicSquareLayout(Context context) {
        super(context);
    }
    public DynamicSquareLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }
    public DynamicSquareLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    @Override public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec);
        int size = MeasureSpec.getSize(widthMeasureSpec);
        setMeasuredDimension(size, size);
    }
}