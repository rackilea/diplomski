public class Vehicle {
    String make;
    String model;
    int year;
    int id;
    double bill;

    public Vehicle() {
        // Get an ID
        this.id = IdProvider.getInstance().getUniqueId();
    }
}

public class Car extends Vehicle {
    private int noDoors;
    public Car(String make, String model, int year, int noDoors) {
        // An ID is fetched implicitly because
        // the super-constructor of Vehicle is
        // always called

        this.noDoors = noDoors;
        this.make = make;
        this.model = model;
        this.year = year;
    }
}