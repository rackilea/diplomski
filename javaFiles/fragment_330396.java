import com.fasterxml.jackson.databind.ObjectMapper;

public class Tester {
    static ObjectMapper mapper=new ObjectMapper();

    public static void main(String[] args) throws IOException {
        Car car = new Car();
        car.setModel("sedan");
        String jsonCar=mapper.writeValueAsString(car);
        System.out.println(jsonCar);
        Vehicle c=mapper.readValue(jsonCar, Vehicle.class);
        System.out.println("Vehicle of type: "+c.getClass().getName());

        Truck truck=new Truck();
        truck.setPower(100);
        String jsonTruck=mapper.writeValueAsString(truck);
        System.out.println(jsonTruck);
        Vehicle t=mapper.readValue(jsonTruck, Vehicle.class);
        System.out.println("Vehicle of type: "+t.getClass().getName());
    }
}