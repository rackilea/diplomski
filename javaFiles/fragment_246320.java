public abstract class Projectile {
    private final float maxSpeed;

    protected Projectile(float maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    // Only if you really need this...
    protected Projectile() {
        this(200f);
    }

    public final getMaxSpeed() {
        return maxSpeed;
    }
}

public class Arrow extends Projectile {
    public Arrow() {
        super(100f);
    }
}