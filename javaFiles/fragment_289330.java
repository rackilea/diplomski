public void onCreate(Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);
    setContentView(R.layout.down_tabs);
    initTabs();
}

private void initTabs() {
    // Set Calendar Tab
    // getTabWidget().setDividerDrawable(R.drawable.tab_divider);
    getTabWidget().setPadding(0, 0, 0, 0);
    addTab("", R.drawable.home_tab_drawable, CalendarUIActivity.class);
    addTab("", R.drawable.lucky_dates_drawable, LuckyDatesActivity.class);
    addTab("", R.drawable.life_stages_drawable, LifeStagesActivity.class);
    addTab("", R.drawable.find_items_drawable, FindItemsActivity.class);
    addTab("", R.drawable.more_tab_drawable, MoreActivity.class);
}

private void addTab(String labelId, int drawableId, Class<?> targetClass) {
    TabHost tabHost = getTabHost();
    Intent intent = new Intent(this, targetClass);
    TabHost.TabSpec spec = tabHost.newTabSpec("tab" + labelId);

    View tabIndicator = LayoutInflater.from(this).inflate(
            R.layout.tab_indicator, getTabWidget(), false);
    TextView title = (TextView) tabIndicator.findViewById(R.id.title);
    title.setText(labelId);
    ImageView icon = (ImageView) tabIndicator.findViewById(R.id.icon);
    icon.setImageResource(drawableId);

    tabIndicator.setBackgroundResource(R.drawable.tab_backgroud);
    // //////////
    spec.setIndicator(tabIndicator);
    spec.setContent(intent);
    tabHost.addTab(spec);

}