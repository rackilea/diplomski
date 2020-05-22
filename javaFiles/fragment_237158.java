import java.util.ArrayList;
import java.util.List;

import cars.Car;
import cars.Motorcycle;
import cars.Vehicle;


public class VehiclesHolder {

    List<VehicleHolder> vehicles=new ArrayList<>();

    public static class VehicleHolder {
        Car car;
        Motorcycle motorcycle;
        public Car getCar() {
            return car;
        }
        public void setCar(Car car) {
            this.car = car;
        }
        public Motorcycle getMotorcycle() {
            return motorcycle;
        }
        public void setMotorcycle(Motorcycle motorcycle) {
            this.motorcycle = motorcycle;
        }
    }

    public List<VehicleHolder> getVehiclesHolder() {
        return vehicles;
    }

    public void setVehiclesHolder(List<VehicleHolder> vehicles) {
        this.vehicles = vehicles;
    }
    public List<Vehicle> getVehicles()
    {
        List<Vehicle> result=new ArrayList<Vehicle>();
        for(VehicleHolder holder:vehicles)
        {
            result.add(holder.getCar()!=null?holder.getCar():holder.getMotorcycle());
        }
        return result;
    }
}