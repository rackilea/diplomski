public void update(Ball ball){
    if(ball.getY() < this.y){
        yv = -1;
    }
    else if(ball.getY() > this.y){
        yv = 1;
    }
    y = y + yv;
}