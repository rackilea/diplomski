Fragment fragmentA = Fragment.instantiate(this, FragmentA.class.getName());
    Fragment fragmentB = Fragment.instantiate(this, FragmentA.class.getName());
    ..
    getSupportFragmentManager().beginTransaction()
            .add(R.id.container, fragmentA)
            .add(R.id.container, fragmentB)
            .show(fragmentA)
            .hide(fragmentB)
            .commit();

    ..
    // Once you want to show fragment B instead of fragment A
    getSupportFragmentManager().beginTransaction()
            .show(fragmentB)
            .hide(fragmentA)
            .commit();