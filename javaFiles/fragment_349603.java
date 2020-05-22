public class ViewPagerActivity extends Activity {
                String text[] = {"A", "B",
                        "C", "D",
                        "E", "F",
                        "G", "H"};

                @Override
                public void onCreate(Bundle savedInstanceState) {
                    super.onCreate(savedInstanceState);
                    setContentView(R.layout.activity_main);
                    MyPagerAdapter adapter = new MyPagerAdapter(this, text);
                    ViewPager myPager = (ViewPager) findViewById(R.id.viewpager);
                    myPager.setAdapter(adapter);
                    myPager.setCurrentItem(0);
//set Page Change Listner. to get callback on page changed or swiped
    myPager .setOnPageChangeListener(new OnPageChangeListener() {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                }

                @Override
                public void onPageSelected(int position) {
                    Log.e("Page Changed ", " YES ");
                    /// here you can check & perform on changed
                    Log.e("Current TextView Text ", text[position]);
                }

                @Override
                public void onPageScrollStateChanged(int state) {

                }
            });

                }
            }