for (int i = 0; i < balls.length; ++i) {
    Ball b1 = balls[i];
    for (int j = i+1; j < balls.length; ++j) {
        Ball b2 = balls[j];
        if (b1.intersects(b1, b2)) {
            // ...
        }
    }
}