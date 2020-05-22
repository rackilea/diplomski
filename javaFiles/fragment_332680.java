public class CustomTextView extends TextView {

    public CustomTextView(final Context context) {
        this(context, null);
    }

    public CustomTextView(final Context context,
            @Nullable final AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomTextView(final Context context, @Nullable final AttributeSet attrs,
            final int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setText(BigDecimal bigDecimal) {
        setText(bigDecimal.toString());

        // Set color
        if (bigDecimal.compareTo(BigDecimal.ZERO) == -1) {
            setBackgroundTintList(new ColorStateListStud().getList(ContextCompat.getColor(getContext(), R.color.lightred)));
        } else if (bigDecimal.compareTo(BigDecimal.ZERO) == 1) {
            setBackgroundTintList(new ColorStateListStud().getList(ContextCompat.getColor(getContext(), R.color.lightgreen)));
        } else {
            setBackgroundTintList(new ColorStateListStud().getList(ContextCompat.getColor(getContext(), R.color.transparent)));
        }
    }
}