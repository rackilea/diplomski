abstract class Vehicle {
    public abstract int getTires();
}

class Car extends Vehicle {
    @Override
    public int getTires() { return 4; }
}

class Motocycle extends Vehicle {
    @Override
    public int getTires() { return 2; }
}