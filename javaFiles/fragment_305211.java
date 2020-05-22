class Vehicle { void launch(); }
class Car extends Vehicle {}
class NuclearMissile extends Vehicle {}
...
// this is prohibited because of below code
List<? extends Vehicle> cars = new ...
// imagine this is possible...
cars.add(new NuclearMissile());
// now this is possible
cars.get(0).launch();