private void parseAttributes(AttributeSet attrs) {
    int attrArray[] = StyleableHelper.getResourceDeclareStyleableIntArray(getContext(), "com_facebook_profile_picture_view");
    //TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.com_facebook_profile_picture_view);
    TypedArray a = getContext().obtainStyledAttributes(attrs, attrArray);

    setPresetSize(a.getInt(0, CUSTOM));
    isCropped = a.getBoolean(1, IS_CROPPED_DEFAULT_VALUE);
    //setPresetSize(a.getInt(R.styleable.com_facebook_profile_picture_view_preset_size, CUSTOM));
    //isCropped = a.getBoolean(R.styleable.com_facebook_profile_picture_view_is_cropped, IS_CROPPED_DEFAULT_VALUE);
    a.recycle();
}