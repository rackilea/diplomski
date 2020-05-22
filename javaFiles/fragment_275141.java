import java.util.ArrayList;
import java.util.List;

public class GenericsSample {

    public static void main(String[] args) {
        Garage<Car> carGarage = new Garage<>();

        Car c = new Car();
        carGarage.addVehicle(c);
        c.setGarage(carGarage);
    }

    abstract static class Vehicle<T extends Vehicle<T>> {

        private Garage<T> garage;

        void setGarage(Garage<T> g) {
            this.garage = g;
            g.vehicles.add(self());
        }

        abstract T self();
    }

    static class Car extends Vehicle<Car> {

        @Override
        Car self() {
            return this;
        }
    }

    static class Garage<T extends Vehicle<T>> {

        List<T> vehicles = new ArrayList<>();

        void addVehicle(T t) {
            vehicles.add(t);
        }
    }
}