class VehicleManager {
    private List<Car> carList = new ArrayList<>();
    private List<Boat> boatList = new ArrayList<>();
    private List<Plane> planeList = new ArrayList<>();

    private AddTransportVisitor addVisitor = new AddTransportVisitor(this);

    public void add(Vehicle vehicle) {
        vehicle.accept(addVisitor);
    }

    public List<Car> getCarList() {
        return carList;
    }

    public List<Boat> getBoatList() {
        return boatList;
    }

    public List<Plane> getPlaneList() {
        return planeList;
    }
}