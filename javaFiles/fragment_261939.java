private TabLayout tabLayout;

// in onCreate()
tabLayout = (TabLayout) findViewById(R.id.tabs);
for (int i = 0; i < NUM_TABS; i++) {
    TabLayout.Tab tab = tabLayout.newTab()
            .setText("tab name")
            .setCustomView(R.layout.custom_tab);
    tabLayout.addTab(tab);
}