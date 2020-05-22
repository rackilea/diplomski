public class MAIN extends ApplicationAdapter {
    SpriteBatch batch;
    Texture img;
    TextureRegion textureRegion;
    float drawingWidth,drawingHeight;

    @Override
    public void create () {
        batch = new SpriteBatch();
        img = new Texture("spike.png");

        img.setWrap(Texture.TextureWrap.Repeat, Texture.TextureWrap.ClampToEdge);
        int width=Gdx.graphics.getWidth();

        textureRegion=new TextureRegion(img,0,0,width,img.getHeight());

        drawingWidth=width;
        drawingHeight=Gdx.graphics.getHeight()*.2f; 
   }

    @Override
    public void render () {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(textureRegion,0,0,drawingWidth,drawingHeight);
        batch.end();
    }

    @Override
    public void dispose () {
        batch.dispose();
        img.dispose();
    }
}