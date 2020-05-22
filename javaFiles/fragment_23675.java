import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.ParticleEffectPool;
import com.badlogic.gdx.graphics.g2d.ParticleEffectPool.PooledEffect;

...

ParticleEffect template = new ParticleEffect();
template.load(Gdx.files.internal("data/particle/bigexplosion.p"),
            ..texture..);
ParticleEffectPool bigExplosionPool = new ParticleEffectPool(template, 0, 20);

...

ParticleEffect particle = bigExplosionPool.obtain();

... // Use the effect, and once it is done running, clean it up

bigExplosionPool.free((PooledEffect) particle);