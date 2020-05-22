class Vehicle { }

class Bike extends Vehicle { }

class VehicleFactory {
    static Vehicle create() {
        Vehicle vehicle = new Vehicle();
        initialize(vehicle);
        return vehicle;
    }

    private static void initialize(Vehicle vehicle) {
        result.setCode("1");
        result.setNumber("2");
        // ...
    }
}

class BikeFactory {
    static Bike create() {
        Bike bike = new Bike();
        VehicleFactory.initialize(bike);
        return bike;
    }
}