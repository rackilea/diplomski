ParticleEffectPool.PooledEffect effect = particleEffectPool.obtain();
effect.reset();
effect.setPosition(posnX,posnY);

//divide by 1000 to convert from ms to seconds
float skipDuration = 0.5f * effect.getEmitters().first().duration / 1000f;
//I guess, to reduce number of iterations in a loop, you can safely use 
//a bit bigger stepDeltaTime, like 1 / 10f or bigger, but it depends on you effect;
//here I just use standard frame duration
final float stepDeltaTime = 1 / 60f;

while (skipDuration > 0) {
    float dt = skipDuration < stepDeltaTime ? skipDuration : stepDeltaTime;
    effect.update(dt);
    skipDuration -= stepDeltaTime;
}