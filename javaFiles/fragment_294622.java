switch (id) {
            case R.id.nav_product:
                replaceFragment(PRODUCT_FRAGMENT);
                break;
            case R.id.nav_redirection:
                replaceFragment(REDIRECTION_FRAGMENT);
                break;
}

private void replaceFragment(String tag) {
    FragmentManager fragmentManager = getSupportFragmentManager();
    FragmentTransaction transaction = fragmentManager.beginTransaction();
    Fragment currentFragment = fragmentManager.findFragmentById(R.id.fr_container);
    Fragment nextFragment = fragmentManager.findFragmentByTag(tag);

    Log.d(TAG, "f detached: " + currentFragment.toString());
    transaction.detach(currentFragment);

    if (nextFragment == null) {
        nextFragment = createFragment(tag);
        transaction.add(R.id.fr_container, nextFragment, tag);
    } else {
        Log.d(TAG, "f attach: " + nextFragment.toString());
        transaction.attach(nextFragment);
    }
    transaction.commit();
}

private Fragment createFragment(String tag) {
    Fragment result = null;
    switch (tag) {
        case CALLHISTORY_FRAGMENT:
            result = new AppCallHistoryFragment();
            break;
        case CALLTRACKING_FRAGMENT:
            result = new AppCallTrackingFragment();
            break;
        case REDIRECTION_FRAGMENT:
            result = new AppRedirectFragment();
            break;
    }
    Log.d(TAG, "create: " + result.toString());
    return result;
}