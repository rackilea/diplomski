private Texture ballTexture;
private Sprite  ballSprite;
private SpriteBatch batch;
private dirY = 2;

create(){
  ballTexture = new Texture("football.jpg");
  ballSprite = new Sprite(ballTexture);
  batch = new SpriteBatch();
}

render(float delta){
  recalculateBallPos(delta);          
  batch.begin();
  sprite.draw(batch);
  batch.end();
  stage.draw();    
}

private void recalculateBallPos(delta){
  float curPos = ballSprite.getY();

  if(curPos + dirY > 100 || curPos + dirY < 0){
    dirY = dirY * -1 //Invert direction 
  }

  ballSprite.setY(curPos+dirY)
}