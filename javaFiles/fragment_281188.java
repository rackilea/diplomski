public void expandTV(TextView txtSubtitle) {
        txtSubtitle.setVisibility(View.VISIBLE);
        txtArrowTV.setText(R.string.fa_icon_chevron_up);
        mAnimatorTV = slideAnimator(0, txtSubtitleHeight);
        mAnimatorTV.start();
    }