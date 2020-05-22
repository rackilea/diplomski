public class TestSampleTabDefault extends SherlockActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @SuppressLint("NewApi")
    public static class SampleTabsDefault extends FragmentActivity implements ServiceConnection {
        private static final String[] CONTENT = new String[] { "Albums", "Artists", "Songs", "Playlist","Genre","Recently Played","Easy Transfer" };
        Handler mHandler;
        //Runnable mRunnable;
        private ServiceToken mToken;
        private IRemoteService  mIRemoteService;
        public static ViewPager pager;
        public static int index = 0;
        public static android.app.ActionBar mActionBar;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.simple_tabs);

            //getSupportActionBar().setHomeButtonEnabled(true);
            //ActionBar bar = getSupportActionBar();
            //bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
            //bar.setDisplayOptions(0, ActionBar.DISPLAY_SHOW_TITLE);

            FragmentPagerAdapter adapter = new GoogleMusicAdapter(getSupportFragmentManager());

            pager = (ViewPager)findViewById(R.id.pager);
            pager.setAdapter(adapter);

            /*getSupportActionBar().setTitle(name);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);*/

            TabPageIndicator indicator = (TabPageIndicator)findViewById(R.id.indicator);
            indicator.setViewPager(pager);

            index = getIntent().getExtras().getInt("index");
            if(index >0){
                indicator.setCurrentItem(index);
            }

        }

        class GoogleMusicAdapter extends FragmentPagerAdapter {
             private final FragmentManager mFragmentManager;
             private Fragment mFragmentAtPos0;
            public GoogleMusicAdapter(FragmentManager fm) {
                super(fm);
                mFragmentManager = fm;
            }
            @Override
            public Fragment getItem(int position) {
               // return TestFragment.newInstance(CONTENT[position % CONTENT.length]);
                Fragment fm = null;

                if(position==0){// LOAD ALBUMS
                    fm = ArtistList.ArtistListFragment.newInstance();
                    return fm;

                }else if(position==1){// LOAD ARTISTS
                    //Toast.makeText(getApplicationContext(), "Select Album", Toast.LENGTH_SHORT).show();
                    fm = ArtistList.ArtistListFragment.newInstance();
                    return fm;
                }else if(position==2){// LOAD SONGS
                    fm = SongsList.SongsListFragment.newInstance(); 
                    return fm;
                }else if(position==3){   // PLaylist
                    fm = PlaylistList.PlayListFragment.newInstance();
                    return fm;
                }else if(position==4){ // Genre List
                    fm = GenreList.GenreListFragment.newInstance();
                    return fm;
                }else if(position==5){ // Recent List
                    fm = RecentAddedList.RecentListFragment.newInstance();
                    return fm;
                }else{
                    fm = TestFragment.newInstance(CONTENT[position]);
                }
                return fm;


            }

            @Override
            public CharSequence getPageTitle(int position) {
                return CONTENT[position % CONTENT.length].toUpperCase();
            }

            @Override
            public int getCount() {
              return CONTENT.length;
            }

            @Override
            public int getItemPosition(Object object)
            {
                if (object instanceof AlbumListFragment && mFragmentAtPos0 instanceof TestFragment)
                    return POSITION_NONE;
                return POSITION_UNCHANGED;
            }

        }

    }
}