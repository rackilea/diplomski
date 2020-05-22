public final class Hero {
    private int hp;
    private int strength;
    private int agility;
    private int armor;
    ...

    public void dealDamageTo(Hero other) {
        other.takeDamage(stength);
    }

    public void takeDamage(int damage) {
        hp = hp - Math.max(0, damage-armor);
    }
    ...
}