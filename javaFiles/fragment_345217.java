public class TabActivity extends TabActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab_screen);
        TabHost tabHost = getTabHost();
        Intent intent = new Intent().setClass(this, ActivityStack.class);
        TabHost.TabSpec spec = tabHost.newTabSpec("tabId").setIndicator("Temp", getResources().getDrawable(R.drawable.home));
        spec.setContent(intent);

        tabHost.addTab(spec);

        Intent intent1 = new Intent().setClass(this, ActivityStack.class);
        TabHost.TabSpec spec1 = tabHost.newTabSpec("tabId").setIndicator("Temp", getResources().getDrawable(R.drawable.invoice));
        spec1.setContent(intent1);
        tabHost.addTab(spec1);

        tabHost.setCurrentTab(0);
    }
}