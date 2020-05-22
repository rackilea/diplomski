AssetManager assetManager=new AssetManager();
    assetManager.setLoader(TextureAtlas.class, new TextureAtlasLoader(new InternalFileHandleResolver()));
    assetManager.load("ani.pack", TextureAtlas.class);
    assetManager.finishLoading();

    TextureAtlas atlas=assetManager.get("ani.pack");