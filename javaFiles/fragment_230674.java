@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    View parent = getLayoutInflater().inflate(R.layout.activity_layout, null);
    setContentView(parent);

    fragmentManager = getSupportFragmentManager();
    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
    Fragment fragment = MyFragment.newInstance();
    fragmentTransaction.add(R.id.framelayout, fragment, "MyFragment");
    fragmentTransaction.commit();
}