@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

// The Action Bar is a window feature. The feature must be requested
// before setting a content view. Normally this is set automatically
// by your Activity's theme in your manifest. The provided system
// theme Theme.WithActionBar enables this for you. Use it as you would
// use Theme.NoTitleBar. You can add an Action Bar to your own themes
// by adding the element <item name="android:windowActionBar">true</item>
// to your style definition.
    getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
    setContentView(R.layout.main);

// experiment with the ActionBar 
    ActionBar actionBar = getActionBar();
}