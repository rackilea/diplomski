try {
        this.mBuildableTexture.build(new BlackPawnTextureBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(1));
    } catch (final TextureAtlasSourcePackingException e) {
        Debug.e(e);
    }

    this.mEngine.getTextureManager().loadTexture(this.mBuildableTexture);