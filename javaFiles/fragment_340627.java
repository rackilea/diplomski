public void updateTexture(final Bitmap bmp) {

     Gdx.app.postRunnable(new Runnable() {
            @Override
            public void run() {            
                mTexture    = new Texture( mImageHelper.bitmapToPixmap( bmp ) );
                mSprite.setTextureRegion(new TextureRegion(mTexture));
            }
     });

}