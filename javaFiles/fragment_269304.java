private void TabInitialize(Bundle args) 
 {
    mTabHost = (TabHost)findViewById(android.R.id.tabhost);
    mTabHost.setup();
    TabInformation tabInfo = null;
    MainActivity.AddTab(this,mTabHost, mTabHost.newTabSpec("Tab1").setIndicator("Andorid"), ( tabInfo = new TabInformation("Tab1", AndroidFragment.class, args)));
    mTabInfo.put(tabInfo.tag, tabInfo);
    MainActivity.AddTab(this, mTabHost, mTabHost.newTabSpec("Tab2").setIndicator("Apple"), ( tabInfo = new TabInformation("Tab2", AppleFragment.class, args)));
    mTabInfo.put(tabInfo.tag, tabInfo);
    MainActivity.AddTab(this, mTabHost, mTabHost.newTabSpec("Tab3").setIndicator("Microsoft"), ( tabInfo = new TabInformation("Tab3", MicrosoftFragment.class, args)));
    mTabInfo.put(tabInfo.tag, tabInfo);
    setSelectedTabColor();
 }