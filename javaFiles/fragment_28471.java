private void addGroundOverlay() {
    // Add ground overlay with the bitmap's initial state
    mGroundOverlay = mMap.addGroundOverlay(new GroundOverlayOptions());

    // TODO: Set values for bitmap's initial state

    // Paint the canvas with the initial state
    updateCanvas();

    // Update the ground overlay
    updateOverlay();

    mAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
        @Override
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            // Update animation values
            mPulseColor = Color.RED; // TODO: set color/alpha

            // Paint canvas with new animation state
            updateCanvas();

            // Update overlay
            updateOverlay();
        }
    });
}