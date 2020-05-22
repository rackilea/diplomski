if (findViewById(R.id.fragment_container) != null) {

        if (savedInstanceState != null) {
            return;
        }

        // Create an instance of ExampleFragment
        HeadlinesFragment firstFragment = new HeadlinesFragment();
        // if there are any extras
        firstFragment.setArguments(getIntent().getExtras());

        // Add the fragment to the 'fragment_container' FrameLayout
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container, firstFragment).commit();
    }