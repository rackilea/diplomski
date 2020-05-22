@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FragmentManager fragmentManager = getFragmentManager();
        Fragment fragment = AnyFragment.instantiate(this, AnyFragment.class.getName());
        fragmentManager.beginTransaction().add(R.id.fragment_placeholder, fragment).addToBackStack(null).commit();
    }