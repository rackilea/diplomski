@Override
protected void onApplyThemeResource(Resources.Theme theme, int resid,
        boolean first) {
    if (mParent == null) {
        super.onApplyThemeResource(theme, resid, first);
    } else {
        try {
            theme.setTo(mParent.getTheme());
        } catch (Exception e) {
            // Empty
        }
        theme.applyStyle(resid, false);
    }

    // Get the primary color and update the TaskDescription for this activity
    if (theme != null) {
        TypedArray a = theme.obtainStyledAttributes(com.android.internal.R.styleable.Theme);
        int colorPrimary = a.getColor(com.android.internal.R.styleable.Theme_colorPrimary, 0);
        a.recycle();
        if (colorPrimary != 0) {
            ActivityManager.TaskDescription v = new ActivityManager.TaskDescription(null, null,
                    colorPrimary);
            setTaskDescription(v);
        }
    }
}