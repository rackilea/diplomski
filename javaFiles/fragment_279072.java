class Vehicle {
  VehicleType type; //e.g. Aircraft, Boat, Car
  Set<Features> features; //e.g. 2 wheels, 4 wheels, wings etc.
  Behavior behavior; //Class to implement specific behavior, depending on your needs
}

class AircraftBehavior extends Behavior {
  void fly() {
    //implements flying mechanic
  }

  //method overridden/implemented from Behavior
  @Override
  void move() {  
    fly();
  }
}

//create an aircraft
Vehicle aircraft = new Vehicle( VehicleType.AIRCRAFT, new HashSet<Feature>(new WingsFeature()), new AircraftBehavior());