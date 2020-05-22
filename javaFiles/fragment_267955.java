for (int i=0; i<5; i++){
    if (!Gdx.input.isTouched(i)) continue;
    Vector2 touchPos = new Vector2(Gdx.input.getX(i), Gdx.input.getY(i) + playerOnePaddle.height / 2);
    if (Gdx.input.getX(i) < Gdx.graphics.getWidth() / 2){
        playerOnePaddle.pos.y = Gdx.graphics.getHeight() - touchPos.y;
    }
    if (Gdx.input.getX(i) > Gdx.graphics.getWidth() / 2){
        playerTwoPaddle.pos.y = Gdx.graphics.getHeight() - touchPos.y;
    }
}