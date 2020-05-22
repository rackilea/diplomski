public void timer(float time) {
    new CountDownTimer(time, 10) {
        // YOUR CODE
    }
}

public void onClick (View view) {
    score++;
    tvscore.setText(String.valueOf(score));
    timer(Math.max(5000-score*500, 2000));
}