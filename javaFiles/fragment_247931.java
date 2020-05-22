public class YourActivity implements principalFragment.OnFragmentInteractionListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        principalFragment hello = principalFragment.newInstance();
        fragmentTransaction.replace(R.id.fragment_container, hello, hello.TAG);
        fragmentTransaction.commit();
    }

    ...
    // Implement the listener's methods
    // @Override
}