private void checkCollision(){
 //detects collision
 if (r!=null && Rect.intersects(r, GameScreen.basket.getBounds())){
    visible = false;
    GameScreen.score +=1;
 }
}