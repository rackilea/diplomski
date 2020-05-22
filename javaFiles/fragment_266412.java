public class MainActivity extends AppCompatActivity {

    SqlAccess sqlAccess;

    //Declaring TabLayout and ViewPager
    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        sqlAccess = new SqlAccess(this);

        viewPager = (ViewPager) findViewById(R.id.view_pager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);

    }
 private void setupViewPager(ViewPager viewPager) {
        SectionsPagerAdapter adapter = new SectionsPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new Tab1Pagina_Inicial(), "ONE");
        adapter.addFragment(new Tab2Apartamentos(), "TWO");
        adapter.addFragment(new Tab3ItensDeApartamentos(), "THREE");
        viewPager.setAdapter(adapter);
    }

    @Override
    protected void onDestroy() {
        sqlAccess.getDbHelper().close();
        super.onDestroy();
    }
}