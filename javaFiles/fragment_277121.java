@Override
public void onBackPressed(){
    FragmentManager fm = getFragmentManager();
    if (fm.getBackStackEntryCount() > 0) {
        Log.i("MainActivity", "popping backstack");
        fm.popBackStack();
        Fragment fragment = getFragmentManager().findFragmentByTag("YOUR_TARGET_FRAGMENT_TAG");
        if (fragment instanceof FragmentA) {
            // add your code to change title of toolbar
        }
    } else {
        Log.i("MainActivity", "nothing on backstack, calling super");
        super.onBackPressed();  
    }
}