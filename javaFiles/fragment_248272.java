public interface StatProvider {
    int health();

    int intellect();
}

public class Ring implements StatProvider {
    @Override
    public int health() {
        return 0;
    }

    @Override
    public int intellect() {
        return 5;
    }
}

public class Mage implements StatProvider {

    private final int baseHealth = 100;
    private final int baseIntellect = 20;

    private List<StatProvider> equipment;

    @Override
    public int health() {
        return baseHealth + equipment.stream().mapToInt(StatProvider::health).sum();
    }

    @Override
    public int intellect() {
        return baseIntellect + equipment.stream().mapToInt(StatProvider::intellect).sum();
    }
}