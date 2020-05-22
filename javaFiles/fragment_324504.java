public enum Brand {
    MINI,
    FERRARI,
    PAGANI
}

public enum Engine {
    LEVEL1,
    LEVEL2,
    LEVEL3
}

public class Entry {
    public final Predicate<Car> pred;
    public final Engine engine;

    public Entry(Predicate<Car> pred, Engine engine) {
        this.pred = pred;
        this.engine = engine;
    }
}

public class Car {
    int model;
    int year;
    Engine engine;

    public void carEngineCalculator(Brand b) {
        Car mycar = new Car();

        List<Entry> cases = new ArrayList<>();
        cases.add(new Entry(c -> c.isSuperCar(b) && c.isCrazyGood(b), Engine.LEVEL1));
        cases.add(new Entry(c -> c.isSuperCar(b) && !c.isCrazyGood(b), Engine.LEVEL2));
        cases.add(new Entry(c -> !c.isSuperCar(b), Engine.LEVEL3));

        mycar.engine = cases.stream().filter(x -> x.pred.test(mycar)).findFirst().get().engine;

    }

    public boolean isSuperCar(Brand b) {
        if ((b == Brand.FERRARI) || (b == Brand.PAGANI)) {
            return true;
        }
        return false;
    }

    public boolean isCrazyGood(Brand b) {
        return false;
    }
}