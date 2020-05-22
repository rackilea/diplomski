public abstract class Entity {
    // [...]

    public void takeDamage(int damage) {
        health -= dmg;
    }

    public void attack() {
        return attackDamage;
    }
}