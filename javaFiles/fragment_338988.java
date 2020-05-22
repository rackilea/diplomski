public class UnitDetailsActivity extends AppCompatActivity {

  private ViewPager viewPager;

   @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit_details);


 viewPager = (android.support.v4.view.ViewPager)findViewById(R.id.container);

  // Getting unitID  via and pass it to Fragment ???
  int unitID = getIntent().getStringExtra("SelectedUnitDeviceId");
  // And how to pass it to Fragment?      

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {                
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        adapter = new ViewPagerUnitDetailsAdapter(this.getSupportFragmentManager());
        fragmentReportHauls = new FragmentReportHauls();
        fragmentReportsDowntime = new FragmentReportsDowntime();

        adapter.addFragment(fragmentReportHauls, unitID);
        adapter.addFragment(fragmentReportsDowntime, unitID);

        viewPager.setAdapter(adapter);

}
}