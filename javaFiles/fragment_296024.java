interface Driveable {
  void drive();
}

class Car implements Driveable {
@Override
void drive() {
   System.out.println("Car drive");
}
}
class Bike implements Driveable {
@Override
void drive() {
   System.out.println("Bike drive");
}
}
class Bicycle implements Driveable {
@Override
void drive() {
   System.out.println("Bicycle drive");
}
}