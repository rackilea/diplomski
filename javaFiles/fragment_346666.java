public class MyAnimationListener implements AnimationListener {
    private ImageButton mImgButton;

    public MyAnimationListener(ImageButton imgButton) {
        mImgButton = imgButton;
    }

    @Override
    public void onAnimationEnd(Animation animation) {
        mImgButton.setVisibility(View.GONE);

    }

    @Override
    public void onAnimationRepeat(Animation animation) {
        // TODO Auto - generated method stub

    }

    @Override
    public void onAnimationStart(Animation animation) {
        // TODO Auto - generated method stub

    }

}