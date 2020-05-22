public abstract class Vehicle {
    public abstract void drive();
}

public abstract class Car extends Vehicle {
    public void drive() {
        System.out.println("Driving around...");
    }
    public void honkHorn() {...}
}

public final class Bus extends Car {
}

public final class Truck extends Car {
    @Override
    public void drive() {
        super.drive();
        honkHorn();
    }
}