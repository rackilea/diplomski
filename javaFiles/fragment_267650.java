public abstract class AbstractLazyCarBuilder<T extends Car, B extends AbstractLazyCarBuilder<T, B>> {

    private String brand;

    private String speed;

    public B brand(String brand) {
        this.brand = brand;
        return (B) this;
    }

    public B speed(String speed) {
        this.speed = speed;
        return (B) this;
    }

    public T build() {
        T car = this.create();
        this.fill(car);
        return car;
    }

    protected abstract T create();

    protected void fill(T car) {
        car.setBrand(this.brand);
        car.setSpeed(this.speed);
    }
}

public class LazyCarBuilder extends AbstractLazyCarBuilder<Car, LazyCarBuilder> {

    @Override
    protected Car create() {
        return new Car();
    }
}

public class LazyTruckBuilder extends AbstractLazyCarBuilder<Truck, LazyTruckBuilder> {

    private String length;

    public LazyTruckBuilder length(String length) {
        this.length = length;
        return this;
    }

    @Override
    protected Truck create() {
        return new Truck();
    }

    @Override
    protected void fill(Truck truck) {
        super.fill(truck); // very important! fills truck with car's common attributes 
        truck.setLength(this.length);
    }
}