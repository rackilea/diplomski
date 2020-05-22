import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

abstract class Vehicle {
}

class MotorCycle extends Vehicle {
   String name;

   MotorCycle(String name) {
      this.name = name;
   }
   public String toString() {
      return name;
   }
}

class Car extends Vehicle {
   String name;

   Car(String name) {
      this.name = name;
   }

   public String toString() {
      return name;
   }
}

public class CarMapper {

   public static void main(String[] args) {
      List<Vehicle> list = new ArrayList<>();
      list.add(new MotorCycle("Honda"));
      list.add(new MotorCycle("Harley-Davidson"));
      list.add(new Car("Ford"));
      list.add(new Car("Chrysler"));

      Map<Class<?>, List<Vehicle>> inventory = list.stream().collect(
            Collectors.groupingBy(Object::getClass));

     }
}