public class Enemy {

    private String name;
    private Integer healthPoint;
    private Integer manaPoint;
    private Integer attackPower;

    // getter, setter, constructors
    // example constructor
    public Enemy(String name, Integer hp, Integer mp, Integer ap) {
        this.name = name;
        this.healthPoint = hp;
        this.manaPoint = mp;
        this.attackPower = ap;
    }
}