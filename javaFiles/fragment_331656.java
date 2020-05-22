public interface Vehicle {
    // common behavior declared, if any
}

public class Car implements Vehicle {
    // Implementation
}

public class Bike implements Vehicle {
    // Implementation
}

public class Garage {
    Vehicle vehicle;

    public Garage(Vehicle v) {
       vehicle = v;
    }
}