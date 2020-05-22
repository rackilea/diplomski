private boolean welcomeShown;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_list);

        if (findViewById(R.id.item_detail_container) != null) { 
            mTwoPane = true;
            ((MainFragment) getSupportFragmentManager().findFragmentById(
                    R.id.item_list)).setActivateOnItemClick(true);
        }

        if (savedInstanceState != null){
                    welcomeShown = savedInstanceState.getBoolean("displayed");
        }

        if(!welcomeShown){

            if (mTwoPane){
                WelcomeFragment welcomeFragment = new WelcomeFragment();
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.item_detail_container, welcomeFragment)
                        .commit();
            }
            else{

                Intent welcomeIntent = new Intent(this, WelcomeActivity.class);
                startActivity(welcomeIntent);
                welcomeShown = true;
            }
        }           
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean("displayed", true);
    }