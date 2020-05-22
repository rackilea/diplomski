private ViewPager pager;
private ViewPagerAdapter pagerAdapter;

@Override
public View onCreateView(...) {
    ...
    pagerAdapter = new ViewPagerAdapter(
         getActivity(),                    // pass the context,
         getChildFragmentManager(),        // the fragment manager
         MainActivity.getFilterManager()   // and the filter manager
    );
}