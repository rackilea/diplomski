Iterator<Fireball> it = fireBalls.iterator();
while (it.hasNext()) {
    Fireball ball = it.next();
    if (ball.x > D_W) {
        // You can't call this.  The Iterator is backed by the ArrayList
        //fireBalls.remove(ball);
        it.remove();
    } else {
        ball.x += X_INC;
        repaint();
    }
}