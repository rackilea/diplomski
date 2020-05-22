public class Vehicle {
    private static int nextId = 0;

    String make;
    String model;
    int year;
    int id;
    double bill;

    public Vehicle() {
        // Get an ID
        this.id = Vehicle.nextId;

        // Increase the ID for the next vehicle
        Vehicle.nextId++;
    }
}