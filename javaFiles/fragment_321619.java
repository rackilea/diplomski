public void startMovie() {
        // "ball" means, that Animators API will search for `public setBall(int)` method inside MyView.java and call that method
        ObjectAnimator ball = ObjectAnimator.ofInt(myView, "ball", 20, 100);
        ball.setDuration(1000);
        ball.start();
    }