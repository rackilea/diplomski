public class TestGame extends Game {

    private AssetManager assetManager;
    private SpriteBatch spriteBatch;

    @Override
    public void create() {

        assetManager=new AssetManager();
        spriteBatch=new SpriteBatch();
        FileHandleResolver resolver = new InternalFileHandleResolver();
        assetManager.setLoader(FreeTypeFontGenerator.class, new FreeTypeFontGeneratorLoader(resolver));
        assetManager.setLoader(BitmapFont.class, ".otf", new FreetypeFontLoader(resolver));
        FreetypeFontLoader.FreeTypeFontLoaderParameter size03Params = new FreetypeFontLoader.FreeTypeFontLoaderParameter();
        size03Params.fontFileName = "CHARLEMAGNESTD-BOLD.otf";
        size03Params.fontParameters.size = 96;
        assetManager.load("CHARLEMAGNESTD-BOLD.otf", BitmapFont.class, size03Params);

        assetManager.finishLoading();
    }

    @Override
    public void render() {

        spriteBatch.begin();

        if(assetManager.update()){
            BitmapFont font=assetManager.get("CHARLEMAGNESTD-BOLD.otf");
            font.draw(spriteBatch,"HEOOOW",100,100);
        }

        spriteBatch.end();
    }

    @Override
    public void dispose() {
        spriteBatch.dispose();
        assetManager.dispose();
    }
}