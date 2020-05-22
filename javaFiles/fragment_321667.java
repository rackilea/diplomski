public class MainActivity extends Activity implements FragmentAListener
{
    private FragmentA fragmentA;
    private FragmentB fragmentB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentA = (FragmentA) getFragmentManager().findFragmentByTag(FragmentA.class.getSimpleName());
        if (savedInstanceState == null) {
            fragmentA = new FragmentA();
            replaceToFragment(fragmentA, false);
        }
    }

    @Override
    public void onListItemButtonClicked(String itemName) {
        fragmentB = new FragmentB();
        Bundle bundle = new Bundle();
        bundle.putString(FragmentB.ITEM_NAME_KEY, itemName);
        fragmentB.setArguments(bundle);
        replaceToFragment(fragmentB, true);
    }

    public void replaceToFragment(Fragment fragment, boolean addToBackStack) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment, fragment.getClass().getSimpleName());
        if (addToBackStack) {
            transaction.addToBackStack(fragment.getClass().getSimpleName());
        }
        transaction.commit();
    }
}