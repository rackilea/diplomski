public class MyLineChart extends com.github.mikephil.charting.charts.LineChart {
    private Context mContext;

    public MyLineChart(Context context) {
        super(context);
        mContext = context;
    }

    public MyLineChart(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
    }

    public LineChart(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        mContext = context;
    }

    // ...
}