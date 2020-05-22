public void expandTV(final TextView txtSubtitle, final TextView txtArrowTV, final ViewHolder holder) {
    txtSubtitle.setVisibility(View.VISIBLE);

    txtArrowTV.setText(R.string.fa_icon_chevron_up);

    mAnimatorTV = slideAnimator(0, holder.height, txtSubtitle);

    mAnimatorTV.start();
}