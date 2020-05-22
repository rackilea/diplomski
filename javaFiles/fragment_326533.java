public class KalendarView extends LinearLayout {

public KalendarView(Context context) {
    this(context, null);
}

public KalendarView(Context context,
                     @Nullable AttributeSet attrs) {
    super(context, attrs);
    initView();
}

public KalendarView(Context context,
                     @Nullable AttributeSet attrs,
                     int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    initView();
}

private void initView() {
    LayoutInflater.from(getContext()).inflate(R.layout.kalendar_view, this, true);
}
}