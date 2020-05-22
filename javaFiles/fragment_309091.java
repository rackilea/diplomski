class AddTransportVisitor implements VehicleVisitor {
    private VehicleManager manager;

    public AddTransportVisitor(VehicleManager manager) {
        this.manager = manager;
    }

    public void visit(Car car) {
        manager.getCarList().add(car);
    }

    public void visit(Plane plane) {
        manager.getPlaneList().add(plane);
    }

    public void visit(Boat boat) {
       manager.getBoatList().add(boat);
    }
}