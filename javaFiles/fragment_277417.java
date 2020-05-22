frame1 = new TextureRegion(texture, 764, 75, 141, -74);
frame2 = new TextureRegion(texture, 907, 75, 133, -75);

TextureRegion[] frames = { frame1, frame2 };

mySpriteAnimation = new SpriteAnimation(0.06f, frames);
mySpriteAnimation.setScaling(scaler);
mySpriteAnimation.setPlayMode(Animation.PlayMode.LOOP);