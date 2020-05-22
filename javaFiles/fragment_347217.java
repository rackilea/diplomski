public class Car {
    private int fuel;

    public Car(int fuel) {
        this.privateSetFuel(fuel);
    }

    public void setFuel(int fuel) {
        this.privateSetFuel(fuel);
    }

    private void privateSetFuel(int fuel) {
        if (fuel < 0) {
            throw new IllegalArgumentException("'fuel' argument can't be negative");
        }
        this.fuel = fuel;
    }