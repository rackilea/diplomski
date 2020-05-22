public class PostStory extends ActionBarActivity implements ViewPager.OnPageChangeListener {
    ...

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ...
        pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(adapter);
        pager.setOnPageChangeListener(this);
         ...
     } 

     @Override
     public void onPageSelected(int position) {
         if(position == ?) fetchAndSetData(); // Here fetch and set the data
     }

     @Override
     public void onPageScrollStateChanged(int state) {}

     @Override
     public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}

     ...
}