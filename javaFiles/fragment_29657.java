public class TabbedActivity extends AppCompatActivity {

    private SparseArrayCompat<Fragment> fragments = new SparseArrayCompat<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tabbed_activity);
        setTitle("");
        fragments.put(0, new Fragment()); //Here you need to instantiate your fragments
        fragments.put(1, new Fragment()); // instead of new Fragment()
        fragments.put(2, new Fragment()); // like new Tab1Fragment()
        fragments.put(3, new Fragment());
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                changeFragment(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        changeFragment(0);
    }

    private void changeFragment(int position) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        Fragment fragment = fragments.get(position);
        String transactionTag = fragment.getClass().getSimpleName();
        if (fragmentManager.getBackStackEntryCount() > 0 &&
                fragmentManager.getBackStackEntryAt(fragmentManager.getBackStackEntryCount() - 1).getName()
                        .equalsIgnoreCase(transactionTag)) {
            return;
        }
        transaction.replace(R.id.fragmentContainer, fragment, transactionTag);
        transaction.commitAllowingStateLoss();
    }
}