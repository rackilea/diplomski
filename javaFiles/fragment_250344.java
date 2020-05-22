public abstract class Fixer<T extends Vehicle> {
    abstract void fix(T vehicle);
}

public class CarFixer extends Fixer<Car> {
    void fix(Car car) {...}
}