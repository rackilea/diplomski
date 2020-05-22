public class CoinPool extends Pool<Sprite> {
    TextureRegion coinTextureRegion;

    public CoinPool(TextureRegion coinTextureRegion){
        this.coinTextureRegion = coinTextureRegion;
    }

    protected Sprite newObject(){
        return new Sprite(coinTextureRegion);
    }
}