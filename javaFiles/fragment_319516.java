public class Beam{
    private Rectangle bound;
    private TextureRegion texture;
    private float weight = 10; //or gravity or however you want to think about it

    public Beam(float x, float y, float width, float height){
        texture = new Texture(Gdx.files.internal("beam.png"));
        bound = new Rectangle(x,y,width,height);
    }

    public void update(float delta){
        bound.y -= weight*delta;
    }

    public Rectangle getBound(){
        return bound;
    }

    public Texture getTexture(){
        return texture;
    }
}