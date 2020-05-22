private int mThemeId = 0;

...

@Override
protected void onCreate(@Nullable Bundle savedInstanceState) {
    final AppCompatDelegate delegate = getDelegate();
    delegate.installViewFactory();
    delegate.onCreate(savedInstanceState);
    if (delegate.applyDayNight() && mThemeId != 0) {
        // If DayNight has been applied, we need to re-apply the theme for
        // the changes to take effect. On API 23+, we should bypass
        // setTheme(), which will no-op if the theme ID is identical to the
        // current theme ID.
        if (Build.VERSION.SDK_INT >= 23) {
            onApplyThemeResource(getTheme(), mThemeId, false);
        } else {
            setTheme(mThemeId);
        }
    }
    super.onCreate(savedInstanceState);
}

@Override
public void setTheme(@StyleRes final int resid) {
    super.setTheme(resid);
    // Keep hold of the theme id so that we can re-set it later if needed
    mThemeId = resid;
}