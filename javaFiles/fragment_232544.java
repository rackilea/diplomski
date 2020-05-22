public void create(){

[...]
mainStage = new Stage(viewport,batch);
menuStage = new Stage(viewport,batch);
InputMultiplexer multiplexer = new InputMultiplexer();
multiplexer.addProcessor(mainStage);
multiplexer.addProcessor(menuStage);
Gdx.input.setInputProcessor(multiplexer);
[...]

}