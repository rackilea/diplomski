//in create
effect = new ParticleEffect();
FileHandle fileDir = Gdx.files.internal("data");
effect.load(Gdx.files.internal("data/myParticleTxtFile"), fileDir);
effect.start();

//in render
effect.draw(batch, Gdx.graphics.getDeltaTime());
batch.end();