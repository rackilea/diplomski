@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_inspection);

    TabHost tabHost = (TabHost)findViewById(R.id.tabHost);

    tabHost.setup();

    TabHost.TabSpec tabSpec1 = tabHost.newTabSpec("Part1");
    tabSpec1.setContent(R.id.tabPart1);
    tabSpec1.setIndicator("1");
    tabHost1.addTab(tabSpec1);

    TabHost.TabSpec tabSpec2 = tabHost.newTabSpec("Part2");
    tabSpec2.setContent(R.id.tabPart2);
    tabSpec2.setIndicator("2");
    tabHost2.addTab(tabSpec2);

    TabHost.TabSpec tabSpec3 = tabHost.newTabSpec("Part3");
    tabSpec3.setContent(R.id.tabPart3);
    tabSpec3.setIndicator("3");
    tabHost3.addTab(tabSpec3);

    TabHost.TabSpec tabSpec4 = tabHost.newTabSpec("Part4");
    tabSpec4.setContent(R.id.tabPart4);
    tabSpec4.setIndicator("4");
    tabHost4.addTab(tabSpec4);

    TabHost.TabSpec tabSpec5 = tabHost.newTabSpec("Part5");
    tabSpec5.setContent(R.id.tabPart5);
    tabSpec5.setIndicator("5");
    tabHost5.addTab(tabSpec5);
}