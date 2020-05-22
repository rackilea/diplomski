public interface Weapon {
    Integer getDamage();
}

public class Knive implements Weapon {
    // light-weight strategy

    public Integer getDamage() {
        return 100;
    }
}