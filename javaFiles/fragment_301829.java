public class Vehicle {
    public int getWheelCount() {
        return 1;
    }
}

public class Car extends Parent {
    public int getWheelCount() {
        return 4;
    }

    public void blowHorn() {
        System.out.println("Honk honk!");
    }
}

public class Bicycle extends Parent {
    public int getWheelCount() {
        return 2;
    }
}

Car car = new Car();
car.getWheelCount();  // 4
car.blowHorn();  //"Honk honk!"

Vehicle v = new Car();
v.getWheelCount()  // 4
v.blowHorn();  // COMPILE ERROR HERE!  Unknown method

Bicycle b = new Bicycle();
b.getWheelCount();  // 2

Vehicle v = new Bicycle();
v.getWheelCount();  // 2