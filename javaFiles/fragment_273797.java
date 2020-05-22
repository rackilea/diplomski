public void update(){
    int x = Gdx.input.getX();
    int y = HEIGHT - Gdx.input.getY(); 
    // HEIGHT is an static user variable with the game height

    float angle = MathUtils.radiansToDegrees * MathUtils.atan2(y - Spr.getY(), x - Spr.getX());
    Spr.setRotation(angle);
}