public class MainActivity extends FragmentActivity {

    final FragmentContainer [] fragmentContainers = new FragmentContainer[3];
    int currentTabIndex = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final FragmentMetaData [] fragmentContainersMetaData = {
                new FragmentMetaData(FragmentA.class.getName(), null),
                new FragmentMetaData(FragmentB.class.getName(), null),
                new FragmentMetaData(FragmentC.class.getName(), null)
        };

        for (int i = 0; i < fragmentContainers.length; i++) {
            fragmentContainers[i] = (FragmentContainer) Fragment.instantiate(this, FragmentContainer.class.getName());
            fragmentContainers[i].addMetaData(fragmentContainersMetaData[i]);
        }

        tabPageNavigationSelection(0);
    }

    void replaceFragmentBy(final Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();                    
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment);
        fragmentTransaction.commitAllowingStateLoss();
    }

    // Method to switch between tabs
    void tabPageNavigationSelection (final int index) {
        if (currentTabIndex == index) {
            fragmentContainers[currentTabIndex].clearStackExceptRootFragment();
        } else {
            currentTabIndex = index;
            replaceFragmentBy(fragmentContainers[currentTabIndex]);
        }
    }
}