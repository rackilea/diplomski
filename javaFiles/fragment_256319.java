ParticleEffectPool.PooledEffect effect = particleEffectPool.obtain();
effect.reset();
effect.setPosition(posnX,posnY);

//divide by 1000 to convert from ms to seconds
float effectDuration = effect.getEmitters().first().duration / 1000f;
float skipProgress = 0.5f;
effect.update(skipProgress * effectDuration);