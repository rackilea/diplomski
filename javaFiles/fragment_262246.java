@Override
protected void onResume() {
    super.onResume();

    if(FRAGMENT_TO_BE_LOADED == 1) loadFragment1();
    else if(FRAGMENT_TO_BE_LOADED == 2) loadFragment2();
    else if(FRAGMENT_TO_BE_LOADED == 3) loadFragment3();
}