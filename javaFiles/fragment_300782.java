new Handler().postDelayed(new Runnable() {
    public void run() {

        view.clearAnimation();  // <--- whichever view you are animating

        startActivity(new Intent(QuizSplashActivity.this, QuizMenuActivity.class));
        QuizSplashActivity.this.finish();
    }
}, fade2.getDuration());