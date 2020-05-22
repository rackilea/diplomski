private static final int FADE_IN_TIME = 200;

/**
 * Adds fade-in transition when in slideshow mode. Called from PhotoViewerActivity.
 */
public void addImageTransition() {
    // Transition drawable with a transparent drawable and the final bitmap
    final TransitionDrawable td = new TransitionDrawable(new Drawable[] {
            new ColorDrawable(android.R.color.transparent),
            mImageView.getDrawable() });

    mImageView.setImageDrawable(td);
    td.startTransition(FADE_IN_TIME);
}