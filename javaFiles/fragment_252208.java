if (tabId.equalsIgnoreCase(TAB_TAG_FEED)) {
    manageContextualActions(true, false);
    if (mFeedFragment == null) {
        mFeedFragment = new FeedPrincipalList();
        ft.add(R.id.realTabContent, mFeedFragment, TAB_TAG_FEED);
    } else {
        // mFeedFragment = new FeedPrincipalList();
        ft.attach(mFeedFragment);
    }
}

if (tabId.equalsIgnoreCase(TAB_TAG_M_PROFILE)) {
    manageContextualActions(false, false);
    if (mProfileFragmentList == null) {
        mProfileFragmentList = new ProfileFragmentList();
        ft.add(R.id.realTabContent, mProfileFragmentList, TAB_TAG_M_PROFILE);
    } else {
        // mProfileFragmentList = new ProfileFragmentList();
        ft.attach(mProfileFragmentList);
    }
}