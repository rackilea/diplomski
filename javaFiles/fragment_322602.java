Stage iconsStage;
Viewport iconsStageViewport;

Stage toolbarStage;
Viewport toolbarStageViewport;

public void prepareStages()
{
    ... //here you are creating iconsStage, filling it with actors etc...

    toolbarStage = new Stage();
    toolbarStageViewport = ... //create any viewport you need

    toolbarStage.setViewport(toolbarStageViewport );

    ... //now add to toolbarStage a proper listener and listeners to icons etc...
}

...

public void render()
{
    Gdx.gl.glClearColor(0, 0, 0, 1);
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

    iconsStageViewport.update(this.screenWidth, this.screenHeight);
    iconsStage.act();
    iconsStage.draw();

    toolbarStageViewport.update(this.screenWidth, this.screenHeight);
    toolbarStage.act();
    toolbarStage.draw();
}