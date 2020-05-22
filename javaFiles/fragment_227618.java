public abstract class Weapon {
    protected final Integer damage;

    protected Weapon(Integer damage) {
        this.damage = damage;
    }

    // more logic here
}

public class Knive extends Weapon {
    public Knive(){
        super(100);
    }
}