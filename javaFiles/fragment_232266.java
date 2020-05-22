abstract class Vehicle {
    Object vehicleSpecificField1, vehicleSpecificField2;
}

class Car extends Vehicle {
    Object carSpecificField;

    Car(final Object vehicleSpecificField1, final Object vehicleSpecificField2, final Object carSpecificField) {
        this.vehicleSpecificField1 = vehicleSpecificField1;
        this.vehicleSpecificField2 = vehicleSpecificField2;
        this.carSpecificField = carSpecificField;
    }
}

abstract class VehicleBuilder<E extends Vehicle> {
    Object vehicleSpecificField1, vehicleSpecificField2;

    public VehicleBuilder<E> vehicleSpecificField1(final Object vehicleSpecificField1) {
        this.vehicleSpecificField1 = vehicleSpecificField1;
        return this;
    }

    public VehicleBuilder<E> vehicleSpecificField2(final Object vehicleSpecificField2) {
        this.vehicleSpecificField2 = vehicleSpecificField2;
        return this;
    }

    abstract E create();

}

class CarBuilder extends VehicleBuilder<Car> {
    Object carSpecificField;

    public CarBuilder carSpecificField(final Object carSpecificField) {
        this.carSpecificField = carSpecificField;
        return this;
    }

    @Override
    Car create() {
        return new Car(vehicleSpecificField1, vehicleSpecificField2, carSpecificField);
    }
}

public static void main(String[] args) {
    Car car = new CarBuilder().carSpecificField("car").vehicleSpecificField1("foo").vehicleSpecificField2("bar").create();
}