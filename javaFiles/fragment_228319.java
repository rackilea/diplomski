String lastPresentedFragmentTag = "";

public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
    switch (menuItem.getItemId()){
        case R.id.navigation_profile:
            // getTagForFragmentId() can be just a switch case function
            // or you can hardcode value instead
            String fragmentTag = getTagForFragmentId(R.id.navigation_profile);
            presentFragment(fragmentTag);
            return true;
        //...


public void presentFragment(String fragmentTag) {
    if (lastPresentedFragmentTag == fragmentTag) {
        return;
    }

    FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
    // Hide previous fragment
    if (lastPresentedFragmentTag != null) {
        Fragment lastFragmenter code hereent = getSupportFragmentManager().findFragmentByTag(lastPresentedFragmentTag);
        ft.hide(lastFragment);
    }

    Fragment currentFragment = getSupportFragmentManager().findFragmentByTag(fragmentTag);
    if (currentFragment == null) {

            // Implement getFragmentForFragmentTag(fragmentTag) it will be another switch case function that will return you fragment
            val fragment = getFragmentForFragmentTag(fragmentTag);
            transaction.add(R.id.fragmentContainer, fragment, tag);
        } else {
            transaction.show(currentFragment);
        }
    }

    transaction.commitNow();
}