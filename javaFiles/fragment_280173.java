import java.util.HashMap;

public class ConsumptionManager {
    private HashMap<CarType, Consumption> data = new HashMap<>();

    public Consumption addTripData(CarType type, double miles, double gallons) throws IllegalArgumentException {
        if (type == null) {
            throw new IllegalArgumentException("Car type cannot be null");
        }
        Consumption consumption = data.get(type);
        if (consumption == null) {
            consumption = new Consumption();
            data.put(type, consumption);
        }
        consumption.addTrip(miles, gallons);

        return consumption;
    }

    public Consumption getConsumption(CarType type) throws IllegalArgumentException {
        if (type == null) {
            throw new IllegalArgumentException("Car type cannot be null");
        }
        return data.get(type);
    }

}