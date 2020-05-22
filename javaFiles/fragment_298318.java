public EditText(Context context) {
    this(context, null);
}
public EditText(Context context, AttributeSet attrs) {
    this(context, attrs, com.android.internal.R.attr.editTextStyle);
}
public EditText(Context context, AttributeSet attrs, int defStyleAttr) {
    this(context, attrs, defStyleAttr, 0);
}
public EditText(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
    super(context, attrs, defStyleAttr, defStyleRes);
}