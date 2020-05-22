public class Vehicle {
}

public class Car extends Vehicle {
    private final int numberOfPassengers;

    public Car(int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    } 
}

public interface VehicleFactory {
    Vehicle createPassengerVehicle(int numberOfPassengers);
}

@Configuration
public class CarFactoryConfiguration {
    @Bean
    VehicleFactory carFactory() {
        return new VehicleFactory() {
            @Override
            Vehicle createPassengerVehicle(int numberOfPassengers) {
                return new Car(numberOfPassengers);
            }
        };
    }
}