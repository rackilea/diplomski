@SuppressWarnings("deprecation")
public TextView(
        Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
    super(context, attrs, defStyleAttr, defStyleRes);
    // TextView is important by default, unless app developer overrode attribute.
    if (getImportantForAutofill() == IMPORTANT_FOR_AUTOFILL_AUTO) {
        setImportantForAutofill(IMPORTANT_FOR_AUTOFILL_YES);
    }
    setTextInternal("");
    [rest of code removed for clarity]