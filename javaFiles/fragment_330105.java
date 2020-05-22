public class Sword {

    private TextureRegion sprite;

    private int x;
    private int y;
    private int size;

    public Sword() {
        Random r = new Random();
        x = (r.nextInt(5)+1)*GameRender.tilesize;
        y = (r.nextInt(5)+1)*GameRender.tilesize;
        size = GameRender.tilesize;
        sprite = AssetLoader.s1;        
    }

    public void createMe() { 
        GameRender.batch.draw(sprite, x, y, size, size);    
    }
}