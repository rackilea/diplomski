protected class MyTabsListener implements ActionBar.TabListener{
    private Fragment fragment;

    public MyTabsListener(Fragment fragment){
        this.fragment = fragment;
    }
    public void onTabSelected(Tab tab, FragmentTransaction ft){
        ft.add(R.id.layout2, fragment, null);
    }
    public void onTabReselected(Tab tab, FragmentTransaction ft) {
    }
    public void onTabUnselected(Tab tab, FragmentTransaction ft) {
        ft.remove(fragment);
    }
}