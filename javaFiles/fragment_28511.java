private void expand() {
    txtB.setVisibility(View.VISIBLE);
    txtExpandCollapse.setText(R.string.fa_icon_chevron_up);
    mAnimator = slideAnimator(0,textBHeight); 
    mAnimator.start();
}