private void loadGameFonts()
{
    FontFactory.setAssetBasePath("font/");
    final ITexture mainFontTexture = new   BitmapTextureAtlas(activity.getTextureManager(), 256, 256, TextureOptions.BILINEAR);
    font = FontFactory.createStrokeFromAsset(activity.getFontManager(), mainFontTexture, activity.getAssets(), "font.ttf", 50, true, Color.WHITE, 2, Color.BLACK);
    //mainFontTexture.load();
    font.load();
}