private void handleToolbarTitleVisibility(float percentage) {
        if (percentage >= PERCENTAGE_TO_SHOW_TITLE_AT_TOOLBAR) {

            if(!mIsTheTitleVisible) {
                startAlphaAnimation(mTitle, ALPHA_ANIMATIONS_DURATION, View.VISIBLE);
                mIsTheTitleVisible = true;
            }

        } else {

            if (mIsTheTitleVisible) {
                startAlphaAnimation(mTitle, ALPHA_ANIMATIONS_DURATION, View.INVISIBLE);
                mIsTheTitleVisible = false;
            }
        }

        if(percentage >= 0.9f)
        {
            mToolbar.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.colorPrimary));
        }
        else
        {
            mToolbar.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),android.R.color.transparent));
        }
}