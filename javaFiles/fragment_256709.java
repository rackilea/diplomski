if(savedInstanceState != null)
    {
        TripReportsFragment frag = new TripReportsFragment();
        frag.setArguments(getIntent().getExtras());
        getSupportFragmentManager().beginTransaction().add(android.R.id.content, frag).commit();
    }