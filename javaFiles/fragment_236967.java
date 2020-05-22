interface Vehicle { /* ... */ }
class Car implements Vehicle { /* ... */ }
class ElectricCar extends Car { /* ... */ }

// This works because ElectricCar is a Car, which is a Vehicle.
Vehicle vehicle = new ElectricCar();