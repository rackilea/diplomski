public class MyClass {

private Vehicle vehicle;

public void doStuff() {

    doNonVehicleStuff();

    Vehicle vehicle = getVehicle();

    doRegularStuff(vehicle);

    if (vehicle instanceof Car) {
        SteeringWheel steeringWheel = ((Car) vehicle).getSteeringWheel();
        doSteeringWheelStuff(steeringWheel);
    }
}