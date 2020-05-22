public class Car {
  String make;
  String model;
  String color;
  String condition;
  void washMe() {
    this.condition = "clean";
  }
  void goOffroad() {
    this.condition = "dirty";
  }
}