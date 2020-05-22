class NoviceDriver {
    Vehicle myVehicle;
    public NoviceDriver(Vehicle vehicle) {
        myVehicle = vehicle;
    }
    void doSomething() {
        myVehicle.start();
        myVehicle.stop();
    }
}
class AdvancedDriver {
    VehicleWithSteering myVehicle;
    public NoviceDriver(VehicleWithSteering vehicle) {
        myVehicle = vehicle;
    }
    void doSomethingElse() {
        myVehicle.start();
        myVehicle.steerLeft();
        myVehicle.stop();
    }
}