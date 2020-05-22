@Override
    public void onBackPressed() {
        int stackCount = getFragmentManager().getBackStackEntryCount();
        if (stackCount == 1) {
            super.onBackPressed(); // if you don't have any fragments in your backstack yet.
        } else {
        // just replace container with fragment as you normally do;

        FragmentManager fm = getFragmentManager();
        fm.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);//clear backstackfirst and then you can exit the app onbackpressed from home fr
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.container, new HomeFragment());
        transaction.commit();
        }
    }