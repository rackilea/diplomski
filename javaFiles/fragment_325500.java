if (TAG_MERGE.equals(childName)) {
    // Inflate all children.
    rInflate(childParser, parent, childAttrs, false);
} else {
    [...]

    // We try to load the layout params set in the <include /> tag. If
    // they don't exist, we will rely on the layout params set in the
    // included XML file.

    [...]

    // Attempt to override the included layout's android:id with the
    // one set on the <include /> tag itself.
    TypedArray a = mContext.obtainStyledAttributes(attrs,
        com.android.internal.R.styleable.View, 0, 0);
    int id = a.getResourceId(com.android.internal.R.styleable.View_id, View.NO_ID);
    // While we're at it, let's try to override android:visibility.

    [...]
}