final int size = imageView.length;
final int animTime = 300;
final Handler animationHandler = new Handler();
Runnable animationRunnable = new Runnable() {

    int i = 0;

    @Override
    public void run() {
        if(i == size-1){
            animationHandler.removeCallbacks(this);
            return;
        }
        imageView[i++].animate().alpha(0f).setDuration(animTime).start();
        imageView[i].animate().alpha(1f).setDuration(animTime).start();
        animationHandler.postDelayed(this, animTime);
    }
};

animationHandler.post(animationRunnable);