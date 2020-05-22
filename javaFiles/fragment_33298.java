@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        if(savedInstanceState == null) {
            Fragment frag = new InputFragment();

            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();    
            ft.replace(R.id.fragment_container, frag);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.addToBackStack(null);
            ft.commit();
        }
    }