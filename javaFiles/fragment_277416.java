public class SpriteAnimation extends Animation {

    float scaleX = 1;
    float scaleY = 1;

    /*...duplicate and call through to super constructors here...*/

    public void setScaling(float scale){
        scaleX = scale;
        scaleY = scale;
    }

    public void draw (float stateTime, Batch batch, float x, float y) {
        TextureRegion region = getKeyFrame(stateTime);
        batch.draw(region, x, y, region.width*scaleX, region.height*scaleY);
    }
}