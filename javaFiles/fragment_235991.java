if (savedInstanceState == null) {
   String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
   Bundle bundle = new Bundle();
   bundle.putString("key", message);
   PlaceholderFragment fragobj = new   PlaceholderFragment();
   fragobj.setArguments(bundle);
        getFragmentManager().beginTransaction()
                .add(R.id.container,  fragobj).commit();
    }