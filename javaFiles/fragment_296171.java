private SpriteBatch batch;
private Texture img;
private Animation<TextureRegion> animation;
private TextureRegion[][] regions;
private Array<TextureRegion> frames;

@Override
public void show() {
    batch = new SpriteBatch();
    img = new Texture(Gdx.files.internal("ghosty.png")); //Get Texture from asset folder
    regions = TextureRegion.split(img, 32, 32);
    frames = new Array<TextureRegion>();
    int rows = 5, columns = 5; //How many rows and columns the region have

    //Fill Frames array with the regions of Texture
    for(int i = 0; i < rows; i++){
        for(int j = 0; j < columns; j++){
            frames.add(regions[i][j]);
        }
    }

    //Create Animation. 0.1f is the time how long a frame will occur,
    //is the animation to fast set this number to a higher value
    //so the single frames will stay for a longer time
    animation = new  Animation<TextureRegion>(0.1f, frames, Animation.PlayMode.LOOP);
}

private float stateTime = 0;

@Override
public void render(float delta) {
    //Clear the screen
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    //update state time so animation will go further
    stateTime += delta;

    batch.begin();
    //Draw the current frame
    batch.draw(animation.getKeyFrame(stateTime), 50, 50);
    batch.end();
}