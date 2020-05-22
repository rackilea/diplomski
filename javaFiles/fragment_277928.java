View[] views = new View[] { ... };

// 100ms delay between Animations
long delayBetweenAnimations = 100l; 

for(int i = 0; i < views.length; i++) {
    final View view = views[i];

    // We calculate the delay for this Animation, each animation starts 100ms 
    // after the previous one
    int delay = i * delayBetweenAnimations;

    view.postDelayed(new Runnable() {
        @Override
        public void run() {
            Animation animation = AnimationUtils.loadAnimation(context, R.anim.your_animation);    
            view.startAnimation(animation);
        }
    }, delay);
}