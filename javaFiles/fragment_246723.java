final Animator animator = setupAnimator();
animator.setTarget(view);

// Record the current state
animator.setupStartValues();

modifyChildrenOfLinearLayout();

linearLayout.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
    @Override
    public void onGlobalLayout() {
        // Remove the callback immediately we only need to catch it this one time.
        linearLayout.getViewTreeObserver().removeOnGlobalLayoutListener(this);

        // Record the new state
        animator.setupEndValues();

        // Start the animation
        animator.start();
    }
});