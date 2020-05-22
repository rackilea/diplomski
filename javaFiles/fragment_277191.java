@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login);

    final FrameLayout frameLayout = (FrameLayout) findViewById(R.id.fragment_container);
    if ((frameLayout != null) && (savedInstanceState == null)) {
        final AuthFragment firstFragment = new AuthFragment();
        firstFragment.setArguments(getIntent().getExtras());
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, firstFragment).commit();
        FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) frameLayout.getLayoutParams();
        //left, top, right, bottom
        params.setMargins(10, 0, 0, 0); //setting margin left to 10px
        frameLayout.setLayoutParams(params);
    }
}