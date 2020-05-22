private void update(){
    player.update();
    ball.update();
    ball.Collision(player);
    computer.update(ball);
    ball.Collision(computer);
}