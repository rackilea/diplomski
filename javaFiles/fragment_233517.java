public class MainActivity extends AppCompatActivity implements FragmentInViewPager.Callback {

    private ViewPager mViewPager;

    //...
    @Override
    public void setViewPagerCurrentPage(int page) {
        mViewPager.setCurrentItem(page);
        //Or...if it is inside another Fragment...
        ViewPagerFragment frag = (ViewPagerFragment) getFragmentManager().findFragmentByTag("view_pager_fragment_tag");
        if (frag != null) frag.getViewPager().setCurrentItem(page);
    }