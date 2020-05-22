public class BidFragment extends Fragment {
  @InjectView(R.id.tabs)
  TabLayout tabs;
  @InjectView(R.id.viewpager)
  ViewPager viewpager;
  SupportMapFragment fragment;
  @Override
  public void onAttach(Context context) {
    super.onAttach(context);

}


@Nullable
@Override
public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

    return inflater.inflate(R.layout.fragment_bid_booking, container, false);
}

@Override
public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    FragmentManager fm = getFragmentManager();
    fragment = (SupportMapFragment) fm.findFragmentById(R.id.map_container);
}
@Override
public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    ButterKnife.inject(this, view);
    tabs.addTab(tabLayout.newTab().setText("BID"));
    tabs.addTab(tabLayout.newTab().setText("BOOK"));
    tabs.setTabGravity(TabLayout.GRAVITY_FILL);
    final PagerAdapter adapter = new PagerAdapter
            (getActivity().getSupportFragmentManager(), tabs.getTabCount());
    viewpager.setAdapter(adapter);
    viewpager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
        @Override
        public void onTabSelected(TabLayout.Tab tab) {
            viewpager.setCurrentItem(tab.getPosition());
            onFragmentInteractionListener.OnConfirmrRidesBookingCallBack();
        }

        @Override
        public void onTabUnselected(TabLayout.Tab tab) {

        }

        @Override
        public void onTabReselected(TabLayout.Tab tab) {

        }
    });
}


}