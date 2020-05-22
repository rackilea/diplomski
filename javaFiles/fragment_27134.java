myTabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener(){
  @Override
  public void onTabChanged(String tabId) {
    int tab = myTabHost.getCurrentTab();
    myTabHost.getTabWidget().getChildAt(tab).setBackgroundColor(Color.CYAN);
  }
});