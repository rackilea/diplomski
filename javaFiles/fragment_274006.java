@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

    // Create FragmentTabHost
    mTabHost = new FragmentTabHost(getActivity());
    // Locate fragment1.xml to create FragmentTabHost
    mTabHost.setup(getActivity(), getChildFragmentManager(), R.layout.fragment1);
    mTabHost.addTab(mTabHost.newTabSpec("groups").setIndicator("",getResources().getDrawable(R.drawable.tab_group_icon)),FragmentTab1.class, null);
    mTabHost.addTab(mTabHost.newTabSpec("contacts").setIndicator("",getResources().getDrawable(R.drawable.tab_user_icon)),FragmentTab2.class, null);

    MainActivity.fabButton.setVisibility(View.VISIBLE);
    return mTabHost;
}