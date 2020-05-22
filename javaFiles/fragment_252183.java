private OnTabChangeListener mOnTabChangeListener = new OnTabChangeListener() {
    @Override
    public void onTabChanged(String tag) {
        if (FBIntent.EXTRA_XX.equals(tag)) {
            // Current tab is xx.
            ... if xx not init -> ...
        } else if (FBIntent.EXTRA_YY.equals(tag)) {
            // Current tab is yy.
            ...
        }
    }
};