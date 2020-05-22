MyFragment fragment = new MyFragment();
    callback = fragment;

    getSupportFragmentManager()
            .beginTransaction()
            .add(R.id.content, fragment, "fragmentTag")
            .commit();