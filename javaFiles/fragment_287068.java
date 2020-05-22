InputProcessor inputProcessorOne = new CustomInputProcessor();
InputProcessor inputProcessorTwo = stage;
InputMultiplexer inputMultiplexer = new InputMultiplexer();
inputMultiplexer.addProcessor(inputProcessorOne);
inputMultiplexer.addProcessor(inputProcessorTwo);
Gdx.input.setInputProcessor(inputMultiplexer);