class Vehicle {
    Engine myEngine = new Engine();
    void start() {
        myEngine.start();
    }
    void stop() {
        myEngine.stop();
    }
}
class VehicleWithSteering extends Vehicle {
    Steering mySteering = new Steering();
    void start() {
        mySteering.reset();
        myEngine.start();
    }
    void steerLeft() {
        mySteering.left();
    }
    void steerRight() {
        mySteering.right();
    }
}