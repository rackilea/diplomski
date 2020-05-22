protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.layout_tab_base);

    simpleFrameLayout = findViewById(R.id.simpleFrameLayout);
    tabLayout = findViewById(R.id.simpleTabLayout);

    TabLayout.Tab firstTab = tabLayout.newTab();
    firstTab.setText("Income");
    tabLayout.addTab(firstTab);

    TabLayout.Tab secondTab = tabLayout.newTab();
    secondTab.setText("Expenses");
    tabLayout.addTab(secondTab);

    replaceFragment(1);

    tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
        @Override
        public void onTabSelected(TabLayout.Tab tab) {
            replaceFragment(int tabPosition)
        }            
    });
}

private void replaceFragment(int tabPosition){
    switch (tab.getPosition()) {
        case 0:
            fragment = new IncomeTab();
            break;
        case 1:
            fragment = new ExpenseTab();
            break;
    }
    FragmentManager fm = getSupportFragmentManager();
    FragmentTransaction ft = fm.beginTransaction();
    ft.replace(R.id.simpleFrameLayout, fragment);
    ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
    ft.commit();
}