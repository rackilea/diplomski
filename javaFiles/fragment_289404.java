Fragment fragment = fm.findFragmentById(R.id.fragmentContainer);

    if (fragment == null) {
        fragment = new HorizontalListViewFragment();
        ;
        fm.beginTransaction()
                .add(R.id.fragmentContainer, fragment)
                .commit();
    }