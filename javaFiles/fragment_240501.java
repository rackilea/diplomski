public Coin(Sprite spr, float xPos, float yPos,
    float radius) {
super(spr, xPos, yPos, radius);
setxPos(xPos);
setyPos(yPos);
batch = new SpriteBatch();
time = 0;
loadAnimation();
}




 public void loadAnimation() {
    // TODO Auto-generated method stub
    //batch = new SpriteBatch();
    animation = new Animation(1 / 3f, 
            new TextureRegion(new Texture("coin1.png")), 
            new TextureRegion(new Texture("coin2.png")),
            new TextureRegion(new Texture("coin3.png")), 
            new TextureRegion(new Texture("coin4.png")), 
            new TextureRegion(new Texture("coin5.png")), 
            new TextureRegion(new Texture("coin6.png")), 
            new TextureRegion(new Texture("coin7.png")), 
            new TextureRegion(new Texture("coin8.png")));
    animation.setPlayMode(Animation.PlayMode.LOOP);
}