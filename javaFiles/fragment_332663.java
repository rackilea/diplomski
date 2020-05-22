private boolean isClickEnabled = true;

...

@Override
public synchronized void onClick(View v) {
    if (isClickEnabled) {
        // We disable the click, which will be enabled again when the animation ends
        isClickEnabled = false;

        ...

        animator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                // We enable the click again now that the animation has finished
                isClickEnabled = true;
            }
        });
        animator.start();
    }
}