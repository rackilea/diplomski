public abstract class MyObjectManager {

    private final Map<MyKey, MyObject> objects;
    private final MySystem system;

    MyObjectManager(final Map<MyKey, MyObject> objects, MySystem inputSystem) {
        this.objects = objects;
        this.system = inputSystem;
    }
}

public class ConcreteManager extends MyObjectManager {
    public ConcreteManager(MySystem inputSystem) {
        super(new LinkedHashMap(CAPACITY_1, LOAD_FACTOR_1, true), inputSystem);
    }
}