FreetypeFontLoader.FreeTypeFontLoaderParameter smallFontParams = new FreetypeFontLoader.FreeTypeFontLoaderParameter();
    smallFontParams.fontFileName = "font/Montserrat-SemiBold.ttf";
    smallFontParams.fontParameters.size = 40;
    game.assetManager.load("smallFont.ttf", BitmapFont.class, smallFontParams);

    FreetypeFontLoader.FreeTypeFontLoaderParameter bigFontParams = new FreetypeFontLoader.FreeTypeFontLoaderParameter();
    smallFontParams.fontFileName = "font/Montserrat-SemiBold.ttf";
    smallFontParams.fontParameters.size = 85;
    game.assetManager.load("bigFont.ttf", BitmapFont.class, bigFontParams);