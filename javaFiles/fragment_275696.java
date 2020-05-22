@Override
    public void render() {

        Gdx.input.setInputProcessor(stage);

        simulator.simulate();

        Gdx.gl.glClearColor(0f, 0f, 0f, 1.f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);

        stage.act();
        stage.draw();

        simulator.modelBatch.begin(cam);
        simulator.modelBatch.render(simulator.instances, simulator.environment);
        simulator.modelBatch.end();
    }