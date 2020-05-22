public class CustomEditText extends EditText {

public CustomEditText(Context context, AttributeSet attrs) {
    super(context, attrs);
}

@Override
protected void onFocusChanged(boolean focused, int direction,
        Rect previouslyFocusedRect) {

    if (!focused)
        if (getText().length() == 0)
            setBackgroundColor(Color.WHITE);

    super.onFocusChanged(focused, direction, previouslyFocusedRect);
}
}