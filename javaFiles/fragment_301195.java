final MTSceneTexture sceneTexture = new MTSceneTexture(mtApplication,0, 0, mtApplication.width, mtApplication.height, drawingScene);
    sceneTexture.getFbo().clear(true, 255, 255, 255, 0, true);        
    sceneTexture.setStrokeColor(new MTColor(155,155,155));

    //Background
    MTRectangle background = new MTRectangle(0,0,mtApplication.width, mtApplication.height , mtApplication);
    background.setFillColor(new MTColor(255,244,150,255));

    //Add the scene texture as a child of the background rectangle so the scene texture is drawn in front
    background.addChild(sceneTexture);
    frame.addChild(background);