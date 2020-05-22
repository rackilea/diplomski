fragmentManager.addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
        @Override
        public void onBackStackChanged() {
            Fragment currentFragment = fragmentManager.findFragmentById(R.id.fragment_container);
            if (currentFragment instanceof MainFragment) {
                //place your filtering logic here using currentFragment
            }
         }
  }