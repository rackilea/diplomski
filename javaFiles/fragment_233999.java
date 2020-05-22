public class Hero implements Damage {
    private final Damage damage;

    public Hero(Damage damage) {
        this.damage = damage;
    }

    public void doDamage() {
        damage.doDamage();
    }

}