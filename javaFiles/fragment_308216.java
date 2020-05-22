`   public Fragment getItem(int position) {
         Fragment fragment = null;//Creates a fragment variable to hold the fragment class i create and make it a null so i can catch the error

       if (position == 0) {
            fragment = new PUT_THE_TITLE_OF_YOUR_ACTIVITY_YOU_WANT_TO_USE();//Calls the fragment.
        }

       if (position == 1) {
            fragment = new CALL_A_DIFFERENT_FRAGMENT_OR_ACTIVITY();//Calls the fragment;
        }

       if (position == 2) {
            fragment = new CALL_A_DIFFERENT_FRAGMENT_OR_ACTIVITY();//Calls the fragment.
        }
    return fragment;
}`