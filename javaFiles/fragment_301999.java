/**
 * Skipping calling super when overriding this method results in
 * {@link #onAnimationStart(Animator)} not getting called.
 */
default void onAnimationStart(Animator animation, boolean isReverse) {
    onAnimationStart(animation);
}