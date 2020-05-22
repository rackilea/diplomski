public void checkPaddleCollisions(){
    Rectangle a = new Rectangle(pTop.getX(), pTop.getY(), pTop.getWidth(), pTop.getHeight());
    Rectangle b = ... //Do this for all the paddles.
    Rectangle ball = new Rectangle(ball.getX(), ball.getY(), ball.getWidth(), ball.getHeight());

    if(a.intersects(ball) || b.intersects(ball) || c.intersects(ball) || d.intersects(ball)){
         //Increment score and bounce ball.
    }
}