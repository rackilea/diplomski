public class Car {
    private int fuel;

    public Car(int fuel) {
        checkFuel(fuel);
        this.fuel = fuel;
    }

    public void setFuel(int fuel) {
        checkFuel(fuel);
        this.fuel = fuel;
    }

    private static void checkFuel(int fuel) {
        if (fuel < 0) {
            throw new IllegalArgumentException("'fuel' argument can't be negative");
        }
    }