public abstract class AbstractCar{
    private int capacity;
    public AbstractCar(int capacity) {
        this.capacity = capacity;
    }
}

class BigCar extends AbstractCar{

    public BigCar() {
        super(6);
    }
}

class SmallCar extends AbstractCar{
    public SmallCar() {
        super(4);
    }
}