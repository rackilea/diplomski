private ParticleEffect effect;

//constructor
effect = new ParticleEffect();
effect.load(Gdx.files.internal("data/explosion.p"), Gdx.files.internal("data"));

//render
effect.start();
effect.setPosition(position.x, position.y);
effect.draw(batch, Gdx.graphics.getDeltaTime());