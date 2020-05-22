class VehicleManager {
    private List<Car> carList = new ArrayList<>();
    private List<Boat> boatList = new ArrayList<>();
    private List<Plane> planeList = new ArrayList<>();

    private AddTransportVisitor addVisitor = new AddTransportVisitor(this);

    public void add(Vehicle vehicle) {
        vehicle.accept(addVisitor);
    }

    public void add(Car car) {
        carList.add(car);
    }

    public void add(Boat boat) {
        boatList.add(boat);
    }

    public void add(Plane plane) {
        planeList.add(plane);
    }

    public void printAllVehicles() {
        //loop through vehicles, print
    }
}

class AddTransportVisitor implements VehicleVisitor {
    private VehicleManager manager;

    public AddTransportVisitor(VehicleManager manager) {
        this.manager = manager;
    }

    public void visit(Car car) {
        manager.add(car);
    }

    public void visit(Plane plane) {
        manager.add(plane);
    }

    public void visit(Boat boat) {
       manager.add(boat);
    }
}

public class Main {
    public static void main(String[] args) {
        Vehicle[] vehicles = {
            new Plane(),
            new Car(),
            new Car(),
            new Car(),
            new Boat(),
            new Boat()
        };

        VehicleManager manager = new VehicleManager();
            for(Vehicle vehicle : vehicles) {
                manager.add(vehicle);
            }

            manager.printAllVehicles();
    }
}