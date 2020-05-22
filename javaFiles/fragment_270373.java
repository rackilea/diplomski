public static class WeaponFactory {
    public List<Weapon> availableWeapons() {
        return Arrays.asList(new Dagger(), new Rifle());
    }

    public Weapon create(int type) {
        return availableWeapons().get(type);
    }
}

public interface Weapon {
    public abstract double attack();
    public abstract String name();
}

public static abstract class WeaponAdapter implements Weapon {
    @Override public String toString() {  return name() + " - " + attack(); }
}

public static class Dagger extends WeaponAdapter {
    @Override public double attack() { return 10; }
    @Override public String name() { return "Dagger"; }
}

public static class Rifle extends WeaponAdapter {
    @Override public double attack() { return 80; }
    @Override public String name() { return "Rifle"; }
}