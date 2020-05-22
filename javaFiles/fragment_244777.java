int topLayerStart = index + 1;
    fgLayers = new int[layerNum - topLayerStart];

    for (int x = 0; x < fgLayers.length; x++) {
        fgLayers[x] = x + topLayerStart;
        Gdx.app.log(ChromeGame.LOG, fgLayers[x] + "");
    }