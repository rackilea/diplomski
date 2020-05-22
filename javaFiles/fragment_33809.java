TabFragment tabFragment = (TabFragment) getSupportFragmentManager().findFragmentByTag(TAB_FRAGMENT_TAG);

        // Check if the tab fragment is available
        if (tabFragment != null) {

            // Call your method in the TabFragment
            articleFrag.yourMethod();
    }