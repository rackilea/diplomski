public RadioGroup(Context context) {
    super(context);
    if (!isInEditMode()) {
        init();
    }
}

public RadioGroup(Context context, AttributeSet attrs) {
    super(context, attrs);
    if (!isInEditMode()) {
        TypedArray attributes = context.obtainStyledAttributes(
                attrs, R.styleable.RadioGroup, 0,
                android.R.style.Widget_CompoundButton_RadioButton);

        int value = attributes.getResourceId(R.styleable.RadioGroup_checkedButton,
            View.NO_ID);
        if (value != View.NO_ID) {
            mCheckedId = value;
        }

        attributes.recycle();
        init();
    }
}