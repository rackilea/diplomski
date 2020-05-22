public class AnimationPlus extends Animation {

    float scale;

    public AnimationPlus (float frameDuration, 
            Array<? extends TextureRegion> keyFrames, PlayMode playMode, float scale) 
    {
        super(frameDuration, keyFrames, playMode);
        this.scale = scale;
    }

    public void applyKeyFrameToSprite (float stateTime, Sprite sprite)
    {
        TextureRegion region = getKeyFrame(stateTime);
        sprite.setSize(scale, 
            scale * region.getRegionHeight() / region.getRegionWidth());
    }
}