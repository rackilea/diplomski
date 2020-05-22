public abstract class Entity {
    private int Health;
    private int attackDmg;

    public Entity(int health,  int attackDamage) {
        this.health = health;
        this.attackDamage = attackDamage;
    }
}